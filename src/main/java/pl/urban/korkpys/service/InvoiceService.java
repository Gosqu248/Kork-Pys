package pl.urban.korkpys.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Autowired
    private CustomerService customerService;

    public List<Invoice> createSampleInvoiceList() {
        List<Invoice> invoiceList = new ArrayList<>();

        String [][] invoiceData= {
                {"faktura.jpg", "Styczeń", "2024", "138"},
                {"faktura.jpg", "Luty", "2024", "138"},
                {"faktura.jpg", "Marzec", "2024", "138"},
                {"faktura.jpg", "Kwiecień", "2024", "138"},
                {"faktura.jpg", "Maj", "2024", "138"},

        };

        for(String[] data : invoiceData) {
            Invoice invoice = new Invoice();
            invoice.setImage("/img/" + data[0]);
            invoice.setInvoiceMonth(data[1]);
            invoice.setInvoiceYear(data[2]);
            Long customerId = Long.parseLong(data[3]); // Convert the String to Long
            Customer customer = customerService.getCustomerById(customerId); // Retrieve the Customer object
            invoice.setCustomer(customer); // Set the Customer for the Invoice
            invoiceList.add(invoice);
        }

        return invoiceList;
    }

    @PostConstruct
    private void initDatabaseWithSampleInvoices() {
        if (invoiceRepository.count() == 0) { // Check if the database is empty
            createSampleInvoiceList().forEach(this::addInvoice); // Add sample invoices
        }
    }

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public void updateInvoice(Long id, String image, String invoiceMonth, String invoiceYear) {
        invoiceRepository.updateInvoice(id, image, invoiceMonth, invoiceYear);
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }
}
