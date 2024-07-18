package pl.urban.korkpys.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import pl.urban.korkpys.security.JwtUtil;
import pl.urban.korkpys.service.CustomerDetailsService;
import pl.urban.korkpys.service.CustomerService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomerDetailsService customerDetailsService;
    private final JwtUtil jwtUtil;
    private final CustomerService customerService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          CustomerDetailsService customerDetailsService,
                          JwtUtil jwtUtil,
                          CustomerService customerService) {
        this.authenticationManager = authenticationManager;
        this.customerDetailsService = customerDetailsService;
        this.jwtUtil = jwtUtil;
        this.customerService = customerService;
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
}

@Getter
@Setter
class AuthenticationRequest {
    private String username;
    private String password;
}

@Getter
class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}

@Getter
@Setter
class PasswordChangeRequest {
    private String newPassword;
}
