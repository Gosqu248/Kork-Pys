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
        List<ConstructionEquipment> equipmentList = new ArrayList<>();

        String[][] equipmentData = {
                {"Rusztowanie Elewacyjne", "Duża ilość rusztowania przeznaczonego pod elewacje budynków.", "rusztowanie1.jpg"},
                {"Komplentne szalunki ", "Wynajem kompletnych szalunków lub pojedynczych elementów.", "szalunek2.jpg"},
                {"Walec kolcowy", "Walec kolcowy 1.5t na pilota", "walec2.jpg"},
                {"Koparki gąsienicowe ", "2 Koparki gąsienicowe: | 2t | 3t |", "koparka1.jpg"},
                {"Wiertnica do koparki", "Wiertnica do koparki 250mm", "koparka2.jpg"},
                {"Wozidła", "Wozidła: | 1,5t | 2t | 3t | ", "koparka2.jpg"},
                {"Zagęszczarka", "Zagęszczarka spalinowa 250kg", "skoczek2.jpg"},
                {"Skoczek ", "Zagęszczarka typu skoczek - stopa wibracyjna", "skoczek.jpg"},
        };

        for (String[] data : equipmentData) {
            ConstructionEquipment equipment = new ConstructionEquipment();
            equipment.setTitle(data[0]);
            equipment.setDescription(data[1]);
            equipment.setImage("/img/" + data[2]);
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