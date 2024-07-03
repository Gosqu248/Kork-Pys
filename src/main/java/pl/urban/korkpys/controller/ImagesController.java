package pl.urban.korkpys.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.urban.korkpys.model.Images;
import pl.urban.korkpys.service.ImagesService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Add this line
@RestController
@RequestMapping("/api/images")
public class ImagesController {

    private final ImagesService imagesService;

    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @GetMapping
    public List<Images> getAllImages() {
        return imagesService.getAllImages();
    }
}
