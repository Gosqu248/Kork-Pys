package pl.urban.korkpys.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.urban.korkpys.model.EcoServices;
import pl.urban.korkpys.service.EcoServicesService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200") // Add this line
@RestController
@RequestMapping("/api/eco-services")
public class EcoServicesController {

    private final EcoServicesService ecoServicesService;

    public EcoServicesController(EcoServicesService ecoServicesService) {
        this.ecoServicesService = ecoServicesService;
    }

    @GetMapping
    public List<EcoServices> getAllEcoServices() {
        return ecoServicesService.getAllEcoServices();
    }
    private static final String IMAGE_DIRECTORY = "src/main/resources/static/img/";

    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
        Resource resource = new ClassPathResource(IMAGE_DIRECTORY + filename);

        if (resource.exists() && resource.isReadable()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE); // Adjust content type as needed

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}