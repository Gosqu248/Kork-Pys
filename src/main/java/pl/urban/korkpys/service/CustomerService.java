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

    public boolean updatePasswordByMail(String mail, String newPassword) {
        Customer customer = customerRepository.findByMail(mail).orElse(null);
        if (customer != null) {
            customer.setPassword(newPassword, bCryptPasswordEncoder);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public boolean changeUserPassword(String email, String currentPassword, String newPassword) {
        if (currentPassword == null || newPassword == null) {
            throw new IllegalArgumentException("Passwords cannot be null");
        }
        Customer customer = customerRepository.findCustomerByMail(email).orElse(null);
        if (customer != null && bCryptPasswordEncoder.matches(currentPassword, customer.getPassword())) {
            customer.setPassword(newPassword, bCryptPasswordEncoder);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }


    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
