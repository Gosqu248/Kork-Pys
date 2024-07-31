package pl.urban.korkpys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.repository.InvoiceRepository;

import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerService customerService;
    private static final Logger logger = Logger.getLogger(InvoiceService.class.getName());

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, CustomerService customerService) {
        this.invoiceRepository = invoiceRepository;
        this.customerService = customerService;
    }

    public Customer getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
    }

    public List<Invoice> findAllInvoices() {
        try {
            return invoiceRepository.findAll();
        } catch (Exception e) {
            logger.severe("Error fetching all invoices: " + e.getMessage());
            throw e;
        }
    }

    public List<Invoice> findInvoicesByCustomerId(Long customerId) {
        try {
            return invoiceRepository.findInvoicesByCustomerId(customerId);
        } catch (Exception e) {
            logger.severe("Error fetching invoices for customerId: " + customerId + ", " + e.getMessage());
            throw e;
        }
    }

    public void addInvoice(Invoice invoice) {
        try {
            invoiceRepository.save(invoice);
        } catch (Exception e) {
            logger.severe("Error saving invoice: " + e.getMessage());
            throw e;
        }
    }

    public void deleteInvoice(Long id) {
        try {
            invoiceRepository.deleteById(id);
        } catch (Exception e) {
            logger.severe("Error deleting invoice with id: " + id + ", " + e.getMessage());
            throw e;
        }
    }
}
