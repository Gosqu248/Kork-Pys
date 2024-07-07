package pl.urban.korkpys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.service.InvoiceService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.findAllInvoices();
    }

    @PostMapping
    public void addInvoice(@RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
    }


}
