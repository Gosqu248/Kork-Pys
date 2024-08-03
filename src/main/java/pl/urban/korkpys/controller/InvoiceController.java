package pl.urban.korkpys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.urban.korkpys.repository.InvoiceRepository;
import pl.urban.korkpys.service.InvoiceService;

import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    private final InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceService invoiceService, InvoiceRepository invoiceRepository) {
        this.invoiceService = invoiceService;
        this.invoiceRepository = invoiceRepository;
    }


    @GetMapping
    public ResponseEntity<String> fetchInvoices(@RequestHeader("Authorization") String token) {
        invoiceRepository.findAll();
        return ResponseEntity.ok("Fetching invoices for user: " + token);
    }


}