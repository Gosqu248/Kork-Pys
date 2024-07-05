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

@Service
public class BackgroundJobService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private String accessToken;

    private static final Logger log = LoggerFactory.getLogger(BackgroundJobService.class);

    @Scheduled(fixedRate = 600000) // Co 60 min
    public void fetchCustomersInBackground() {
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
                        .toList();
                customerRepository.saveAll(customers);
                log.info("Successfully fetched and saved customers in background.");
            } catch (IOException e) {
                log.error("Error parsing customer data: " + e.getMessage());
            }
        } else {
            log.error("Failed to fetch customers: " + response.getStatusCode());
        }
    }
}
