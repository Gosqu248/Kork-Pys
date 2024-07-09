package pl.urban.korkpys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.urban.korkpys.dto.InvoiceDto;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.service.InvoiceService;

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

    @PostMapping
    public void addInvoice(@RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
    }


}
