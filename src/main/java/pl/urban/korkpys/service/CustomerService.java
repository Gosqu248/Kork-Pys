package pl.urban.korkpys.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.repository.CustomerRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void removeDuplicateCustomers() {
        List<Customer> customers = customerRepository.findAll();
        Map<String, List<Customer>> groupedByCode = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCustomerCode));

        for (Map.Entry<String, List<Customer>> entry : groupedByCode.entrySet()) {
            List<Customer> duplicates = entry.getValue();
            if (duplicates.size() > 1) {
                Customer primaryCustomer = duplicates.getFirst();
                duplicates.removeFirst();
                customerRepository.deleteAll(duplicates);
            }
        }
    }
}
