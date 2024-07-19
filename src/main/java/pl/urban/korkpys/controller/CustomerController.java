package pl.urban.korkpys.controller;

import org.springframework.web.bind.annotation.*;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.service.CustomerService;
import pl.urban.korkpys.security.JwtUtil; // Assuming you have a JwtUtils class for token operations


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final JwtUtil jwtUtil; 


    public CustomerController(CustomerService customerService, JwtUtil jwtUtil) {
        this.customerService = customerService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public Customer getCustomer(@RequestHeader("Authorization") String token) {
        String subject = jwtUtil.getSubjectFromToken(token.substring(7)); // Assuming token is a Bearer token
        return customerService.getCustomerBySubject(subject);
    }
}
