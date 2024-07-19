package pl.urban.korkpys.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.repository.CustomerRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Customer getCustomerBySubject(String subject) {
        return customerRepository.findByMailOrPhoneNumber(subject, subject).orElse(null);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void updatePassword(Long customerId, String newPassword) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            customer.setPassword(newPassword, bCryptPasswordEncoder);
            customerRepository.save(customer);
        }
    }


    public void saveCustomer(Customer customer) {
        customer.setPassword(customer.getStreet(), customer.getBuildingNumber(), bCryptPasswordEncoder);
        customerRepository.save(customer);
    }
}
