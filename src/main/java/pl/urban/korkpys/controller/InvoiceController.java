package pl.urban.korkpys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.urban.korkpys.dto.InvoiceDto;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.service.InvoiceService;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.findAllInvoices().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private InvoiceDto convertToDto(Invoice invoice) {
        return new InvoiceDto(
                invoice.getId(),
                invoice.getImage(),
                invoice.getInvoiceMonth(),
                invoice.getInvoiceYear(),
                invoice.getCustomer() != null ? invoice.getCustomer().getId() : null
        );
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<String> addInvoice(
            @RequestParam("file") MultipartFile file,
            @RequestParam("invoiceMonth") String invoiceMonth,
            @RequestParam("invoiceYear") String invoiceYear,
            @RequestParam("customer_id") Long customerId) {

        try {
            String imagePath = invoiceService.saveImage(file);

            Invoice invoice = new Invoice();
            invoice.setImage(imagePath);
            invoice.setInvoiceMonth(invoiceMonth);
            invoice.setInvoiceYear(invoiceYear);
            Customer customer = invoiceService.getCustomerById(customerId);
            invoice.setCustomer(customer);

            invoiceService.addInvoice(invoice);
            return ResponseEntity.ok("Invoice added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add invoice");
        }
    }
}
