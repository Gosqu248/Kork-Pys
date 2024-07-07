package pl.urban.korkpys.mapper;

import pl.urban.korkpys.dto.CustomerDto;
import pl.urban.korkpys.dto.InvoiceDto;
import pl.urban.korkpys.model.Customer;
import pl.urban.korkpys.model.Invoice;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static Customer toEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setCustomerCode(dto.getCustomerCode());
        customer.setMail(dto.getMail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setStreet(dto.getStreet());
        customer.setBuildingNumber(dto.getBuildingNumber());
        customer.setCity(dto.getCity());
        customer.setPostalCode(dto.getPostalCode());
        return customer;
    }

    public static CustomerDto toDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setName(customer.getName());
        dto.setCustomerCode(customer.getCustomerCode());
        dto.setMail(customer.getMail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setStreet(customer.getStreet());
        dto.setBuildingNumber(customer.getBuildingNumber());
        dto.setCity(customer.getCity());
        dto.setPostalCode(customer.getPostalCode());
        dto.setInvoices(toInvoiceDtoList(customer.getInvoices()));

        return dto;
    }

    private static List<InvoiceDto> toInvoiceDtoList(List<Invoice> invoices) {
        return invoices.stream()
                .map(CustomerMapper::toInvoiceDto)
                .collect(Collectors.toList());
    }

    private static InvoiceDto toInvoiceDto(Invoice invoice) {
        InvoiceDto dto = new InvoiceDto();
        dto.setId(invoice.getId());
        dto.setImage(invoice.getImage());
        dto.setInvoiceMonth(invoice.getInvoiceMonth());
        dto.setInvoiceYear(invoice.getInvoiceYear());
        return dto;
    }
}