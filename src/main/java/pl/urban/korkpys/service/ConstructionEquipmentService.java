package pl.urban.korkpys.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.ConstructionEquipment;
import pl.urban.korkpys.repository.ConstructionEquipmentRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class ConstructionEquipmentService {

    private final ConstructionEquipmentRepository constructionEquipmentRepository;

    public ConstructionEquipmentService(ConstructionEquipmentRepository constructionEquipmentRepository) {
        this.constructionEquipmentRepository = constructionEquipmentRepository;
    }

    public List<ConstructionEquipment> createConstructionEquipmentList() throws IOException {
        String imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s";

            ConstructionEquipment equipment1 = new ConstructionEquipment();
        equipment1.setTitle("Rusztowanie Elewacyjne");
        equipment1.setDescription("Super rusztowanie do wykonywania prac przy elewacjach");
        equipment1.setImage(imageUrl);

        ConstructionEquipment equipment2 = new ConstructionEquipment();
        equipment2.setTitle("Koparki jednoosiowe");
        equipment2.setDescription("Koparki idealne do wykonywania prac przy mniejszych wykopach");
        equipment2.setImage(imageUrl);

        ConstructionEquipment equipment3 = new ConstructionEquipment();
        equipment3.setTitle("Stemple");
        equipment3.setDescription("Do wykonywania szolunków budowlanych");
        equipment3.setImage(imageUrl);

        ConstructionEquipment equipment4 = new ConstructionEquipment();
        equipment4.setTitle("Deski szolunkowe");
        equipment4.setDescription("Do wykonywania szolunków");
        equipment4.setImage(imageUrl);

        ConstructionEquipment equipment5 = new ConstructionEquipment();
        equipment5.setTitle("Blaty szolunkowe");
        equipment5.setDescription("Do wykonywania szolunków");
        equipment5.setImage(imageUrl);

        ConstructionEquipment equipment6 = new ConstructionEquipment();
        equipment6.setTitle("Wozidła jednoosiowe");
        equipment6.setDescription("Idealne do wykonywania prac ziemnych");
        equipment6.setImage(imageUrl);

        ConstructionEquipment equipment7 = new ConstructionEquipment();
        equipment7.setTitle("Wozidła jednoosiowe");
        equipment7.setDescription("Idealne do wykonywania prac ziemnych");
        equipment7.setImage(imageUrl);

        return Arrays.asList(equipment1, equipment2, equipment3, equipment4, equipment5, equipment6, equipment7);
    }

    @PostConstruct
    public void createAndSaveConstructionEquipment() throws IOException {
        List<ConstructionEquipment> equipmentList = createConstructionEquipmentList();
        for (ConstructionEquipment equipment : equipmentList) {
            if (!constructionEquipmentRepository.existsByTitle(equipment.getTitle())) {
                constructionEquipmentRepository.save(equipment);
            }
        }
    }

    public List<ConstructionEquipment> getAllConstructionEquipment() {
        return constructionEquipmentRepository.findAll();
    }
}
