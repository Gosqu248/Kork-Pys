package pl.urban.korkpys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.urban.korkpys.dto.InvoiceDto;
import pl.urban.korkpys.repository.InvoiceRepository;
import pl.urban.korkpys.service.InvoiceService;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;


    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    public List<InvoiceDto> getAllUserInvoices(
            @RequestParam String street, @RequestParam String buildingNumber) {
        return invoiceService.getAllUserInvoices(street, buildingNumber);
    }


}