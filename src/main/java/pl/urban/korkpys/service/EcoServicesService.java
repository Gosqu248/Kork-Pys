package pl.urban.korkpys.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.ConstructionEquipment;
import pl.urban.korkpys.model.EcoServices;
import pl.urban.korkpys.repository.EcoServicesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EcoServicesService {

    private final EcoServicesRepository ecoServicesRepository;

    public EcoServicesService(EcoServicesRepository ecoServicesRepository) {
        this.ecoServicesRepository = ecoServicesRepository;
    }

    public List<EcoServices> createEcoServicesList() {
        List<EcoServices> ecoList = new ArrayList<>();

        String[][] ecoData = {
                {"Wywóz płynnych nieczystości", "Gwarancją szybkiego i bezpiecznego pozbycia się odpadów.", "szambiarka2.jpg"},
                {"Opróżnianie przydomowych oczyszczalni", "Skuteczne i ekologiczne opróżnianie przydomowych oczyszczalni ścieków. Możliwość stałej współpracy.", "szambiarka4.jpg"},
                {"Wywóz szamba", "Bezproblemowy i higieniczny wywóz szamba z pełnym przestrzeganiem przepisów sanitarnych. Możliwość stałej współpracy.", "szambiarka4.jpg"}
        };

        for (String[] data : ecoData) {
            EcoServices service = new EcoServices();
            service.setTitle(data[0]);
            service.setDescription(data[1]);
            service.setImage("/img/" + data[2]);
            ecoList.add(service);
        }

        return ecoList;
    }

    @PostConstruct
    public void createAndSaveConstructionEquipment() {
        List<EcoServices> existingEquipmentList = ecoServicesRepository.findAll();
        List<EcoServices> newEquipmentList = createEcoServicesList();

        newEquipmentList.forEach(newEquipment -> {
            EcoServices existingEquipment = existingEquipmentList.stream()
                    .filter(e -> e.getTitle().equals(newEquipment.getTitle()))
                    .findFirst()
                    .orElse(null);

            if (existingEquipment != null) {
                boolean hasChanged = !existingEquipment.getDescription().equals(newEquipment.getDescription()) ||
                        !existingEquipment.getImage().equals(newEquipment.getImage());

                if (hasChanged) {
                    existingEquipment.setDescription(newEquipment.getDescription());
                    existingEquipment.setImage(newEquipment.getImage());
                    ecoServicesRepository.save(existingEquipment);
                }
            } else {
                ecoServicesRepository.save(newEquipment);
            }
        });
    }

    public List<EcoServices> getAllEcoServices() {
        return ecoServicesRepository.findAll();
    }
}