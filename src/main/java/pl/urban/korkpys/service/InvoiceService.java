package pl.urban.korkpys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.urban.korkpys.dto.InvoiceDto;
import pl.urban.korkpys.mapper.InvoiceMapper;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.model.Party;
import pl.urban.korkpys.repository.InvoiceRepository;
import pl.urban.korkpys.repository.PartyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Transactional
    public void saveOrUpdateInvoice(Invoice invoice) {
        Party purchasingParty = invoice.getPurchasingParty();
        if (purchasingParty != null && purchasingParty.getId() == null) {
            partyRepository.save(purchasingParty);
        }

        Invoice existingInvoice = invoiceRepository.findByNumber(invoice.getNumber()).orElse(null);
        if (existingInvoice != null) {
            updateInvoice(existingInvoice, invoice);
            invoiceRepository.save(existingInvoice);
        } else {
            invoiceRepository.save(invoice);
        }
    }

    private void updateInvoice(Invoice existingInvoice, Invoice newInvoice) {
        existingInvoice.setNetTotal(newInvoice.getNetTotal());
        existingInvoice.setCurrencyNetTotal(newInvoice.getCurrencyNetTotal());
        existingInvoice.setGrossTotal(newInvoice.getGrossTotal());
        existingInvoice.setCurrencyGrossTotal(newInvoice.getCurrencyGrossTotal());
        existingInvoice.setVatTotal(newInvoice.getVatTotal());
        existingInvoice.setCurrencyVatTotal(newInvoice.getCurrencyVatTotal());
        existingInvoice.setCurrencyCode(newInvoice.getCurrencyCode());
        existingInvoice.setCurrencyRateType(newInvoice.getCurrencyRateType());
        existingInvoice.setCurrencyRateDate(newInvoice.getCurrencyRateDate());
        existingInvoice.setCurrencyConverter(newInvoice.getCurrencyConverter());
        existingInvoice.setCurrencyRate(newInvoice.getCurrencyRate());
        existingInvoice.setPaymentStatus(newInvoice.getPaymentStatus());
        existingInvoice.setOssProcedureCountryCode(newInvoice.getOssProcedureCountryCode());
        existingInvoice.setOssProcedure(newInvoice.isOssProcedure());
        existingInvoice.setFinal(newInvoice.isFinal());
        existingInvoice.setPurchasingParty(newInvoice.getPurchasingParty());
        existingInvoice.setPaymentTypeId(newInvoice.getPaymentTypeId());
        existingInvoice.setPaymentType(newInvoice.getPaymentType());
        existingInvoice.setPaymentDeadline(newInvoice.getPaymentDeadline());
        existingInvoice.setBankAccountId(newInvoice.getBankAccountId());
        existingInvoice.setBankAccountNumber(newInvoice.getBankAccountNumber());
        existingInvoice.setSalesDate(newInvoice.getSalesDate());
        existingInvoice.setInvoiceType(newInvoice.getInvoiceType());
        existingInvoice.getItems().clear();
        existingInvoice.getItems().addAll(newInvoice.getItems());
        existingInvoice.setDescription(newInvoice.getDescription());
        existingInvoice.setIssueDate(newInvoice.getIssueDate());
        existingInvoice.setStatus(newInvoice.getStatus());
    }


    @Transactional(readOnly = true)
    public List<InvoiceDto> getAllUserInvoices(String street, String buildingNumber) {
        return invoiceRepository.findByPurchasingPartyStreetAndPurchasingPartyBuildingNumber(street, buildingNumber)
                .stream()
                .map(InvoiceMapper::toDto)
                .collect(Collectors.toList());
    }
}