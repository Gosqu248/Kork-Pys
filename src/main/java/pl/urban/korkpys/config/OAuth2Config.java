package pl.urban.korkpys.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class OAuth2Config {

    @Value("${comarch.client-id}")
    private String clientId;

    @Value("${comarch.client-secret}")
    private String clientSecret;
    private volatile String accessToken;
    private volatile long expiryTime = 86400000;
    private final ReentrantLock lock = new ReentrantLock();

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getAccessToken() {
        lock.lock();
        try {
            if (accessToken == null || System.currentTimeMillis() >= expiryTime) {
                refreshToken();
            }
            return accessToken;
        } finally {
            lock.unlock();
        }
    }

    private void refreshToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://app.erpxt.pl/api2/public/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String auth = clientId + ":" + clientSecret;
        byte[] encodedAuth = Base64.encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);

        HttpEntity<String> entity = new HttpEntity<>("grant_type=client_credentials", headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
        Map<String, Object> responseBody = response.getBody();

        if (responseBody != null) {
            this.accessToken = (String) responseBody.get("access_token");

            this.expiryTime = System.currentTimeMillis() + (170 * 1000); // 170 seconds in milliseconds
        }
    }
}