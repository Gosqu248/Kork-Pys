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
import pl.urban.korkpys.formatter.DataFormatter;
import pl.urban.korkpys.mapper.CustomerMapper;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.repository.CustomerRepository;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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

    @Scheduled(fixedRate = 6000000) // Every 60 min
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
                List<Customer> customersToUpdateOrSave = customerDtos.stream()
                        .map(CustomerMapper::toEntity)
                        .map(customer -> {
                            customer.setName(DataFormatter.formatNameOrCity(customer.getName()));
                            customer.setCity(DataFormatter.formatNameOrCity(customer.getCity()));
                            customer.setStreet(DataFormatter.formatStreet(customer.getStreet()));

                            if (customerRepository.existsByCustomerCode(customer.getCustomerCode())) {
                                Customer existingCustomer = customerRepository.findByCustomerCode(customer.getCustomerCode());
                                boolean needsUpdate = false;

                                // Check and update each field
                                if (!Objects.equals(existingCustomer.getName(), customer.getName())) {
                                    existingCustomer.setName(customer.getName());
                                    needsUpdate = true;
                                }
                                if (!Objects.equals(existingCustomer.getMail(), customer.getMail())) {
                                    existingCustomer.setMail(customer.getMail());
                                    needsUpdate = true;
                                }
                                if (!Objects.equals(existingCustomer.getPhoneNumber(), customer.getPhoneNumber())) {
                                    existingCustomer.setPhoneNumber(customer.getPhoneNumber());
                                    needsUpdate = true;
                                }
                                if (!Objects.equals(existingCustomer.getStreet(), customer.getStreet())) {
                                    existingCustomer.setStreet(customer.getStreet());
                                    needsUpdate = true;
                                }
                                if (!Objects.equals(existingCustomer.getBuildingNumber(), customer.getBuildingNumber())) {
                                    existingCustomer.setBuildingNumber(customer.getBuildingNumber());
                                    needsUpdate = true;
                                }
                                if (!Objects.equals(existingCustomer.getCity(), customer.getCity())) {
                                    existingCustomer.setCity(customer.getCity());
                                    needsUpdate = true;
                                }
                                if (!Objects.equals(existingCustomer.getPostalCode(), customer.getPostalCode())) {
                                    existingCustomer.setPostalCode(customer.getPostalCode());
                                    needsUpdate = true;
                                }
                                if (!Objects.equals(existingCustomer.getCustomerCode(), customer.getCustomerCode())) {
                                    existingCustomer.setCustomerCode(customer.getCustomerCode());
                                    needsUpdate = true;
                                }

                                if (needsUpdate) {
                                    log.info("Updating customer with code: " + customer.getCustomerCode());
                                    customerService.saveCustomer(existingCustomer);
                                    return existingCustomer;
                                }
                                return existingCustomer;
                            } else {
                                customerService.saveCustomer(customer);
                                return customer;
                            }
                        })
                        .collect(Collectors.toList());

                customerRepository.saveAll(customersToUpdateOrSave);
                log.info("Successfully fetched and updated or saved unique customers in background.");

            } catch (IOException e) {
                log.error("Error parsing customer data: " + e.getMessage());
            }
        } else {
            log.error("Failed to fetch customers: " + response.getStatusCode());
        }
    }
}
