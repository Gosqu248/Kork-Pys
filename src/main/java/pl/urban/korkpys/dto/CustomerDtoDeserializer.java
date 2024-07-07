package pl.urban.korkpys.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomerDtoDeserializer extends StdDeserializer<CustomerDto> {

    public CustomerDtoDeserializer() {
        this(null);
    }

    public CustomerDtoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public CustomerDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(node.get("Name").asText());
        customerDto.setCustomerCode(node.get("CustomerCode").asText());
        customerDto.setMail(node.get("Mail").asText());
        customerDto.setPhoneNumber(node.get("PhoneNumber").asText());

        JsonNode addressNode = node.get("Address");
        if (addressNode != null) {
            customerDto.setStreet(addressNode.get("Street").asText());
            customerDto.setBuildingNumber(addressNode.get("BuildingNumber").asText());
            customerDto.setCity(addressNode.get("City").asText());
            customerDto.setPostalCode(addressNode.get("PostalCode").asText());
        }

        return customerDto;
    }
}