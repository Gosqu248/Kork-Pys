package pl.urban.korkpys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.repository.InvoiceRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerService customerService;
    private final String uploadDir = "uploaded-images";

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, CustomerService customerService) {
        this.invoiceRepository = invoiceRepository;
        this.customerService = customerService;
    }

    public Customer getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public void updateInvoice(Long id, String image, String invoiceMonth, String invoiceYear) {
        invoiceRepository.updateInvoice(id, image, invoiceMonth, invoiceYear);
    }

    public String saveImage(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, file.getBytes());

        return filePath.toString();
    }
}
