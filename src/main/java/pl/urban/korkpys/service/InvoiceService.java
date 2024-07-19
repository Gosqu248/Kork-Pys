package pl.urban.korkpys.service;

import jakarta.annotation.PostConstruct;
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


    public List<Invoice> createInvoiceList() {
        List<Invoice> invoiceList = new ArrayList<>();

        Object[][] invoiceData = {
                {"2024", "Styczeń", "faktura.jpg", 45},
                {"2024", "Luty", "faktura.jpg", 45},
                {"2024", "Marzec", "faktura.jpg", 45},
                {"2024", "Kwiecień", "faktura.jpg", 45},
                {"2024", "Maj", "faktura.jpg", 45},
                {"2024", "Maj", "faktura.jpg", 48},

        };

        for(Object[] data : invoiceData) {
            Invoice invoice = new Invoice();
            invoice.setInvoiceYear((String) data[0]);
            invoice.setInvoiceMonth((String) data[1]);
            invoice.setImage("/img/" + data[2]);
            invoice.setCustomer(getCustomerById(Long.valueOf((Integer) data[3])));
            invoiceList.add(invoice);
        }

        return invoiceList;
    }

    @PostConstruct
    public void addInvoices() {
        List<Invoice> existingInvoices = findAllInvoices();
        List<Invoice> newInvoices = createInvoiceList();

        newInvoices.forEach(newInvoice -> {
            Invoice existingInvoice = existingInvoices.stream()
                    .filter(e -> e.getInvoiceMonth().equals(newInvoice.getInvoiceMonth()))
                    .findFirst()
                    .orElse(null);

            if (existingInvoice == null) {
                addInvoice(newInvoice);
            }
        });
    }

}
