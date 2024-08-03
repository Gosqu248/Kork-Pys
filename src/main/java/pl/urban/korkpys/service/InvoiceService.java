// src/main/java/pl/urban/korkpys/service/InvoiceService.java
package pl.urban.korkpys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.model.Party;
import pl.urban.korkpys.repository.InvoiceRepository;
import pl.urban.korkpys.repository.PartyRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Transactional
    public void saveInvoice(Invoice invoice) {
        Party purchasingParty = invoice.getPurchasingParty();
        if (purchasingParty != null && purchasingParty.getId() == null) {
            partyRepository.save(purchasingParty);
        }
        invoiceRepository.save(invoice);
    }
}