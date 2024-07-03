package pl.urban.korkpys.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.ConstructionEquipment;
import pl.urban.korkpys.repository.ConstructionEquipmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstructionEquipmentService {

    private final ConstructionEquipmentRepository constructionEquipmentRepository;

    public ConstructionEquipmentService(ConstructionEquipmentRepository constructionEquipmentRepository) {
        this.constructionEquipmentRepository = constructionEquipmentRepository;
    }

    public List<ConstructionEquipment> createConstructionEquipmentList() {
        String imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s";
        List<ConstructionEquipment> equipmentList = new ArrayList<>();

        String[][] equipmentData = {
                {"Rusztowanie Elewacyjne", "Duża ilość rusztowania przeznaczonego pod elewacje budynków."},
                {"Komplentne szalunki ", "Wynajem kompletnych szalunków lub pojedynczych elementów."},
                {"Walec kolcowy", "Walec kolcowy 1.5t na pilota"},
                {"Koparki gąsienicowe ", "2 Koparki gąsienicowe: | 2t | 3t |"},
                {"Wiertnica do koparki", "Wiertnica do koparki 250mm"},
                {"Wozidła", "Wozidła: | 1,5t | 2t | 3t | "},
                {"Zagęszczarka", "Zagęszczarka spalinowa 250kg"},
                {"Skoczek ", "Zagęszczarka typu skoczek - stopa wibracyjna"},
        };

        for (String[] data : equipmentData) {
            ConstructionEquipment equipment = new ConstructionEquipment();
            equipment.setTitle(data[0]);
            equipment.setDescription(data[1]);
            equipment.setImage(imageUrl);
            equipmentList.add(equipment);
        }

        return equipmentList;
    }

    @PostConstruct
    public void createAndSaveConstructionEquipment() {
        List<ConstructionEquipment> existingEquipmentList = constructionEquipmentRepository.findAll();
        List<ConstructionEquipment> newEquipmentList = createConstructionEquipmentList();

        newEquipmentList.forEach(newEquipment -> {
            ConstructionEquipment existingEquipment = existingEquipmentList.stream()
                    .filter(e -> e.getTitle().equals(newEquipment.getTitle()))
                    .findFirst()
                    .orElse(null);

            if (existingEquipment != null) {
                boolean hasChanged = !existingEquipment.getDescription().equals(newEquipment.getDescription()) ||
                        !existingEquipment.getImage().equals(newEquipment.getImage());

                if (hasChanged) {
                    existingEquipment.setDescription(newEquipment.getDescription());
                    existingEquipment.setImage(newEquipment.getImage());
                    constructionEquipmentRepository.save(existingEquipment);
                }
            } else {
                constructionEquipmentRepository.save(newEquipment);
            }
        });
    }

    public List<ConstructionEquipment> getAllConstructionEquipment() {
        return constructionEquipmentRepository.findAll();
    }
}