package pl.urban.korkpys.comarchApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/comarch-api")
public class ComarchApiController {
    @Autowired
    private String accessToken;
    private static final Logger log = LoggerFactory.getLogger(ComarchApiController.class);

    @GetMapping("/customers")
    public ResponseEntity<String> getCustomers() {
        try {
            String url = "https://app.erpxt.pl/api2/public/v1.2/customers";
            return getDataFromApi(url);
        } catch (ResourceAccessException e) {
            if (e.getCause() instanceof IOException) {
                // Log the IOException
                log.error("IOException occurred while trying to send the response: " + e.getMessage());
                // Return a server error or a custom response indicating the issue
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending response");
            }
            throw e; // Re-throw if it's not an IOException
        }
    }

    @GetMapping("/invoices")
    public ResponseEntity<String> getInvoices() {
        String url = "https://app.erpxt.pl/api2/public/v1.4/invoices";
        return getDataFromApi(url);
    }

    private ResponseEntity<String> getDataFromApi(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}
