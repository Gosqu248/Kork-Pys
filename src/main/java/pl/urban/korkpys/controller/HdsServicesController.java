package pl.urban.korkpys.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.urban.korkpys.model.HdsServices;
import pl.urban.korkpys.service.HdsServicesService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200") // Add this line
@RestController
@RequestMapping("/api/hds-services")
public class HdsServicesController {

    private final HdsServicesService hdsServicesService;

    public HdsServicesController(HdsServicesService hdsServicesService) {
        this.hdsServicesService = hdsServicesService;
    }

    @GetMapping
    public List<HdsServices> getAllHdsServices() {
        return hdsServicesService.getAllHdsServices();
    }
}