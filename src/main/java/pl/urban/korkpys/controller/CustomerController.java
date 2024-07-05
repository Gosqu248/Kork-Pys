package pl.urban.korkpys.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.service.CustomerService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200") // Add this line
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getCustomers();
    }
}