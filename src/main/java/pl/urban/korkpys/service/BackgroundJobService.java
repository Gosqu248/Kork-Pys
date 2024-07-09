package pl.urban.korkpys.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.urban.korkpys.dto.CustomerDto;
import pl.urban.korkpys.mapper.CustomerMapper;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.repository.CustomerRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BackgroundJobService {

    @Autowired
    private CustomerRepository customerRepository;

    private final TokenService tokenService;
    private final CustomerService customerService;

    private static final Logger log = LoggerFactory.getLogger(BackgroundJobService.class);

    @Autowired
    public BackgroundJobService(CustomerRepository customerRepository, TokenService tokenService, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.tokenService = tokenService;
        this.customerService = customerService;
    }

    @Scheduled(fixedRate = 600000) // Every 60 min
    public void fetchCustomersInBackground() {
        String accessToken = tokenService.getAccessToken();
        String url = "https://app.erpxt.pl/api2/public/v1.2/customers";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            String customersJson = response.getBody();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                List<CustomerDto> customerDtos = objectMapper.readValue(customersJson, new TypeReference<List<CustomerDto>>() {});
                List<Customer> customers = customerDtos.stream()
                        .map(CustomerMapper::toEntity)
                        .filter(customer -> !customerRepository.existsByCustomerCode(customer.getCustomerCode())) // Filter out duplicates based on email
                        .collect(Collectors.toList());
                customerRepository.saveAll(customers);
                log.info("Successfully fetched and saved unique customers in background.");

                // Remove duplicates after saving new customers
                customerService.removeDuplicateCustomers();

            } catch (IOException e) {
                log.error("Error parsing customer data: " + e.getMessage());
            }
        } else {
            log.error("Failed to fetch customers: " + response.getStatusCode());
        }
    }
}
