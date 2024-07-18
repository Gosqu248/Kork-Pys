package pl.urban.korkpys.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
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

//    @Transactional
//    public void removeDuplicateCustomers() {
//        // Retrieve all customers from the database
//        List<Customer> allCustomers = customerRepository.findAll();
//
//        // Group customers by their code to identify duplicates
//        Map<String, List<Customer>> customersGroupedByCode = allCustomers.stream()
//                .collect(Collectors.groupingBy(Customer::getCustomerCode));
//
//        // Iterate over each group of customers with the same code
//        for (Map.Entry<String, List<Customer>> groupEntry : customersGroupedByCode.entrySet()) {
//            List<Customer> customersInGroup = groupEntry.getValue();
//
//            // Check if there are duplicates (more than one customer with the same code)
//            if (customersInGroup.size() > 1) {
//                // Keep the first customer as the primary one and consider the rest as duplicates
//                Customer primaryCustomer = customersInGroup.get(0); // Using get(0) instead of getFirst() for clarity
//                List<Customer> duplicates = customersInGroup.subList(1, customersInGroup.size());
//
//                customerRepository.deleteAll(duplicates);
//            }
//        }
//    }

    public void saveCustomer(Customer customer) {
        customer.setPassword(customer.getStreet(), customer.getBuildingNumber(), bCryptPasswordEncoder);
        customerRepository.save(customer);
    }
}
