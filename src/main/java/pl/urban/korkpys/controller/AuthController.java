package pl.urban.korkpys.controller;

import io.micrometer.common.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import pl.urban.korkpys.security.JwtUtil;
import pl.urban.korkpys.service.CustomerDetailsService;
import pl.urban.korkpys.service.CustomerService;
import pl.urban.korkpys.service.EmailService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomerDetailsService customerDetailsService;
    private final JwtUtil jwtUtil;
    private final CustomerService customerService;
    private final EmailService emailService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          CustomerDetailsService customerDetailsService,
                          JwtUtil jwtUtil,
                          CustomerService customerService,
                          EmailService emailService) {
        this.authenticationManager = authenticationManager;
        this.customerDetailsService = customerDetailsService;
        this.jwtUtil = jwtUtil;
        this.customerService = customerService;
        this.emailService = emailService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = customerDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam Long customerId, @RequestBody PasswordChangeRequest passwordChangeRequest) {
        customerService.updatePassword(customerId, passwordChangeRequest.getNewPassword());
        return ResponseEntity.ok("Password updated successfully");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordResetRequest request) {
        UserDetails user = customerDetailsService.loadUserByUsername(request.getEmail());

        if(user == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Użytkownik nie znaleziony"));
        }

        String token = jwtUtil.generateToken(user);
        // Update the resetUrl to include HTML anchor tag for clickable link
        String resetUrl = "<a href='http://localhost:4200/reset-password?token=" + token + "'>http://localhost:4200/reset-password?token=" + token + "</a>";

        // Update the email content to indicate it's a password reset for Kork-Pyś and include the clickable link
        String emailContent = "Resetowanie hasła do strony Kork-Pyś. <br> <br>  Kliknij w poniższy link, aby zresetować hasło: <br><br>" + resetUrl;
        emailService.sendPasswordResetMail(user.getUsername(), "Resetowanie hasła", emailContent);

        return ResponseEntity.ok(Map.of("message", "Link do resetowania hasła został wysłany na Twój email."));
    }

    @PostMapping("/reset-password/confirm")
    public ResponseEntity<?> confirmResetPassword(@RequestBody PasswordResetConfirmRequest request) {
        String token = request.getToken();
        String newPassword = request.getNewPassword();

        if (StringUtils.isBlank(token)) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "JWT token is missing or empty."));
        }

        try {
            if (jwtUtil.validateToken(token)) {
                String username = jwtUtil.getUsernameFromToken(token);
                boolean updateSuccess = customerService.updatePasswordByMail(username, newPassword);
                if (updateSuccess) {
                    return ResponseEntity.ok(Map.of("message", "Password reset successfully."));
                } else {
                    return ResponseEntity
                            .status(HttpStatus.NOT_FOUND)
                            .body(Map.of("error", "Customer not found."));
                }
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Invalid or expired JWT token."));
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error processing your request."));
        }
    }


}

