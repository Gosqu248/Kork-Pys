package pl.urban.korkpys.mapper;

import pl.urban.korkpys.dto.CustomerDto;
import pl.urban.korkpys.model.Customer;

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
        return dto;
    }
}