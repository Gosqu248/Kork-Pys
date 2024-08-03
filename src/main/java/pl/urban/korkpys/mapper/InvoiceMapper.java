package pl.urban.korkpys.mapper;

import pl.urban.korkpys.dto.InvoiceDto;
import pl.urban.korkpys.model.Invoice;
import pl.urban.korkpys.model.Party;

import java.util.Objects;

public class InvoiceMapper {

    public static InvoiceDto toDto(Invoice invoice) {
        if (invoice == null) return null;

        InvoiceDto dto = new InvoiceDto();
        dto.setId(invoice.getId());
        dto.setNetTotal(invoice.getNetTotal());
        dto.setCurrencyNetTotal(invoice.getCurrencyNetTotal());
        dto.setGrossTotal(invoice.getGrossTotal());
        dto.setCurrencyGrossTotal(invoice.getCurrencyGrossTotal());
        dto.setVatTotal(invoice.getVatTotal());
        dto.setCurrencyVatTotal(invoice.getCurrencyVatTotal());
        dto.setCurrencyCode(invoice.getCurrencyCode());
        dto.setCurrencyRateType(invoice.getCurrencyRateType());
        dto.setCurrencyRateDate(invoice.getCurrencyRateDate());
        dto.setCurrencyConverter(invoice.getCurrencyConverter());
        dto.setCurrencyRate(invoice.getCurrencyRate());
        dto.setPaymentStatus(invoice.getPaymentStatus());
        dto.setOssProcedureCountryCode(invoice.getOssProcedureCountryCode());
        dto.setOssProcedure(invoice.isOssProcedure());
        dto.setFinal(invoice.isFinal());
        dto.setPurchasingParty(toDto(invoice.getPurchasingParty()));
        dto.setPaymentTypeId(invoice.getPaymentTypeId());
        dto.setPaymentType(invoice.getPaymentType());
        dto.setPaymentDeadline(invoice.getPaymentDeadline());
        dto.setBankAccountId(invoice.getBankAccountId());
        dto.setBankAccountNumber(invoice.getBankAccountNumber());
        dto.setSalesDate(invoice.getSalesDate());
        dto.setInvoiceType(invoice.getInvoiceType());
        dto.setItems(invoice.getItems().stream().map(InvoiceMapper::toDto).toList());
        dto.setDescription(invoice.getDescription());
        dto.setIssueDate(invoice.getIssueDate());
        dto.setNumber(invoice.getNumber());
        dto.setStatus(invoice.getStatus());

        return dto;
    }

    public static Invoice toEntity(InvoiceDto dto) {
        if (dto == null) return null;

        Invoice invoice = new Invoice();
        invoice.setId(dto.getId());
        invoice.setNetTotal(dto.getNetTotal());
        invoice.setCurrencyNetTotal(dto.getCurrencyNetTotal());
        invoice.setGrossTotal(dto.getGrossTotal());
        invoice.setCurrencyGrossTotal(dto.getCurrencyGrossTotal());
        invoice.setVatTotal(dto.getVatTotal());
        invoice.setCurrencyVatTotal(dto.getCurrencyVatTotal());
        invoice.setCurrencyCode(dto.getCurrencyCode());
        invoice.setCurrencyRateType(dto.getCurrencyRateType());
        invoice.setCurrencyRateDate(dto.getCurrencyRateDate());
        invoice.setCurrencyConverter(dto.getCurrencyConverter());
        invoice.setCurrencyRate(dto.getCurrencyRate());
        invoice.setPaymentStatus(dto.getPaymentStatus());
        invoice.setOssProcedureCountryCode(dto.getOssProcedureCountryCode());
        invoice.setOssProcedure(dto.isOssProcedure());
        invoice.setFinal(dto.isFinal());
        invoice.setPurchasingParty(toEntity(dto.getPurchasingParty()));
        invoice.setPaymentTypeId(dto.getPaymentTypeId());
        invoice.setPaymentType(dto.getPaymentType());
        invoice.setPaymentDeadline(dto.getPaymentDeadline());
        invoice.setBankAccountId(dto.getBankAccountId());
        invoice.setBankAccountNumber(dto.getBankAccountNumber());
        invoice.setSalesDate(dto.getSalesDate());
        invoice.setInvoiceType(dto.getInvoiceType());
        invoice.setItems(dto.getItems().stream()
                .map(InvoiceMapper::toEntity)
                .filter(Objects::nonNull)
                .toList());
        invoice.setDescription(dto.getDescription());
        invoice.setIssueDate(dto.getIssueDate());
        invoice.setNumber(dto.getNumber());
        invoice.setStatus(dto.getStatus());

        return invoice;
    }

    private static InvoiceDto.PartyDto toDto(Party entity) {
        if (entity == null) return null;

        InvoiceDto.PartyDto dto = new InvoiceDto.PartyDto();
        dto.setName(entity.getName());
        dto.setNipPrefix(entity.getNipPrefix());
        dto.setNip(entity.getNip());
        dto.setCountry(entity.getCountry());
        dto.setCity(entity.getCity());
        dto.setStreet(entity.getStreet());
        dto.setBuildingNumber(entity.getBuildingNumber());
        dto.setFlatNumber(entity.getFlatNumber());
        dto.setBankName(entity.getBankName());
        dto.setBankAccountNumber(entity.getBankAccountNumber());
        dto.setCustomerType(entity.getCustomerType());
        return dto;
    }

    private static Party toEntity(InvoiceDto.PartyDto dto) {
        if (dto == null) return null;

        Party party = new Party();
        party.setName(dto.getName());
        party.setNipPrefix(dto.getNipPrefix());
        party.setNip(dto.getNip());
        party.setCountry(dto.getCountry());
        party.setCity(dto.getCity());
        party.setStreet(dto.getStreet());
        party.setBuildingNumber(dto.getBuildingNumber());
        party.setFlatNumber(dto.getFlatNumber());
        party.setBankName(dto.getBankName());
        party.setBankAccountNumber(dto.getBankAccountNumber());
        party.setCustomerType(dto.getCustomerType());
        return party;
    }

    private static InvoiceDto.InvoiceItemDto toDto(Invoice.InvoiceItem item) {
        if (item == null) return null;

        InvoiceDto.InvoiceItemDto dto = new InvoiceDto.InvoiceItemDto();
        dto.setId(item.getId());
        dto.setProductId(item.getProductId());
        dto.setQuantity(item.getQuantity());
        dto.setProductCurrencyPrice(item.getProductCurrencyPrice());
        dto.setProductPrice(item.getProductPrice());
        dto.setProductName(item.getProductName());
        dto.setProductDescription(item.getProductDescription());
        dto.setUnitOfMeasurement(item.getUnitOfMeasurement());
        dto.setVatRateId(item.getVatRateId());
        return dto;
    }

    private static Invoice.InvoiceItem toEntity(InvoiceDto.InvoiceItemDto dto) {
        if (dto == null || dto.getProductId() == null) return null;

        Invoice.InvoiceItem item = new Invoice.InvoiceItem();
        item.setId(dto.getId());
        item.setProductId(dto.getProductId());
        item.setQuantity(dto.getQuantity());
        item.setProductCurrencyPrice(dto.getProductCurrencyPrice());
        item.setProductPrice(dto.getProductPrice());
        item.setProductName(dto.getProductName());
        item.setProductDescription(dto.getProductDescription());
        item.setUnitOfMeasurement(dto.getUnitOfMeasurement());
        item.setVatRateId(dto.getVatRateId());
        return item;
    }
}