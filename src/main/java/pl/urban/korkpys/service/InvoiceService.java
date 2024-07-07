package pl.urban.korkpys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.repository.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
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
