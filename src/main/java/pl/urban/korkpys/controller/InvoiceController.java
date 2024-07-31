package pl.urban.korkpys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.service.InvoiceService;

import java.io.IOException;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    public ResponseEntity<?> getInvoices() {
        try {

            List<Invoice> invoicesList = invoiceService.findAllInvoices();

            if (invoicesList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No invoices found for the given customerId");
            }
            return ResponseEntity.ok(invoicesList);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid customerId format");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching invoices");
        }
    }


    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<String> addInvoice(
            @RequestParam("image") String image,
            @RequestParam("invoiceMonth") String invoiceMonth,
            @RequestParam("invoiceYear") String invoiceYear,
            @RequestParam("customer_id") Long customerId) {

        Invoice invoice = new Invoice();
        invoice.setImage(image);
        invoice.setInvoiceMonth(invoiceMonth);
        invoice.setInvoiceYear(invoiceYear);
        Customer customer = invoiceService.getCustomerById(customerId);
        invoice.setCustomer(customer);

        invoiceService.addInvoice(invoice);
        return ResponseEntity.ok("Invoice added successfully");
    }



}