package pl.urban.korkpys.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.urban.korkpys.model.ConstructionEquipment;
import pl.urban.korkpys.service.ConstructionEquipmentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Add this line
@RequestMapping("/api/sprzet-budowlany")
public class ConstructionEquipmentController {

    private final ConstructionEquipmentService constructionEquipmentService;

    public ConstructionEquipmentController(ConstructionEquipmentService constructionEquipmentService) {
        this.constructionEquipmentService = constructionEquipmentService;
    }

    @GetMapping
    public List<ConstructionEquipment> getAllConstructionEquipment() {
        return constructionEquipmentService.getAllConstructionEquipment();
    }
}