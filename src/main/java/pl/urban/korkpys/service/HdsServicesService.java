package pl.urban.korkpys.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.EcoServices;
import pl.urban.korkpys.model.HdsServices;
import pl.urban.korkpys.repository.HdsServicesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HdsServicesService {

    private final HdsServicesRepository hdsServicesRepository;

    public HdsServicesService(HdsServicesRepository hdsServicesRepository) {
        this.hdsServicesRepository = hdsServicesRepository;
    }

    public List<HdsServices> createEcoServicesList() {
        List<HdsServices> hdslist = new ArrayList<>();

        String[][] hdsData = {
                {"Przewóz rzeczy wraz z załadunkiem", "Opis usługi wywozu płynnych nieczystości.", "hds3.jpg"},
                {"Usługi transportowe", "Opis usługi opróżniania przydomowych oczyszczalni.", "hds3.jpg"},
                {"Dostawa materiałów z wypożyczalni", "Opis usługi wywozu szamba.", "hds3.jpg"}
        };

        for (String[] data : hdsData) {
            HdsServices service = new HdsServices();
            service.setTitle(data[0]);
            service.setDescription(data[1]);
            service.setImage("/img/" + data[2]);
            hdslist.add(service);
        }

        return hdslist;
    }

    @PostConstruct
    public void createAndSaveConstructionEquipment() {
        List<HdsServices> existingEquipmentList = hdsServicesRepository.findAll();
        List<HdsServices> newEquipmentList = createEcoServicesList();

        newEquipmentList.forEach(newEquipment -> {
            HdsServices existingEquipment = existingEquipmentList.stream()
                    .filter(e -> e.getTitle().equals(newEquipment.getTitle()))
                    .findFirst()
                    .orElse(null);

            if (existingEquipment != null) {
                boolean hasChanged = !existingEquipment.getDescription().equals(newEquipment.getDescription()) ||
                        !existingEquipment.getImage().equals(newEquipment.getImage());

                if (hasChanged) {
                    existingEquipment.setDescription(newEquipment.getDescription());
                    existingEquipment.setImage(newEquipment.getImage());
                    hdsServicesRepository.save(existingEquipment);
                }
            } else {
                hdsServicesRepository.save(newEquipment);
            }
        });
    }

    public List<HdsServices> getAllHdsServices() {
        return hdsServicesRepository.findAll();
    }
}