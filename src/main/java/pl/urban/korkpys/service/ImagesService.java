package pl.urban.korkpys.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.Images;
import pl.urban.korkpys.repository.ImagesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagesService {

    private final ImagesRepository imagesRepository;

    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

public List<Images> createImagesList() {
    List<Images> imagesList = new ArrayList<>();

    String[][] imgData = {
            {"szmabiarka1.jpg", "eco"},
            {"szambiarka2.jpg", "eco"},
            {"szambiarka3.jpg", "eco"},
            {"szambiarka4.jpg", "eco"},
            {"szambiarka5.jpg", "eco"},
            {"szambiarka5.jpg", "eco"},
            {"rusztowanie1.jpg", "rent"},
            {"rusztowanie2.jpg", "rent"},
            {"rusztowanie3.jpg", "rent"},
            {"szolunek1.jpg", "rent"},
            {"szolunek2.jpg", "rent"},
            {"szolunek3.jpg", "rent"},
            {"koparka1.jpg", "rent"},
            {"skoczek.jpg", "rent"},
            {"hds1.jpg", "hds"},
            {"hds2.jpg", "hds"},
            {"hds3.jpg", "hds"},
            {"hds4.jpg", "hds"},
            {"hds5.jpg", "hds"},
            {"hds6.jpg", "hds"},
    };

    for (String[] data : imgData) {
        Images image = new Images();
        image.setImage("/img/" + data[0]);
        image.setCategory(data[1]);
        imagesList.add(image);
    }
    return imagesList;
}

    @PostConstruct
    public void createAndSaveImages() {
        List<Images> existingImagesList = imagesRepository.findAll();
        List<Images> newImagesList = createImagesList();

        newImagesList.forEach(newImage -> {
            Images existingImage = existingImagesList.stream()
                    .filter(e -> e.getImage().equals(newImage.getImage()))
                    .findFirst()
                    .orElse(null);

            if (existingImage == null) {
                imagesRepository.save(newImage);
            }
        });
    }

    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }
}
