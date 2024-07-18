package pl.urban.korkpys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.repository.CustomerRepository;

import java.util.ArrayList;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByMailOrPhoneNumber(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found: " + username));

        String password = customer.getPassword();
        if (password == null || password.isEmpty()) {
            password = customer.getStreet() + customer.getBuildingNumber();
        }

        return new User(username, password, new ArrayList<>());
    }
}