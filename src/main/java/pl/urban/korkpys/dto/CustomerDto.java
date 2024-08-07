package pl.urban.korkpys.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = CustomerDtoDeserializer.class)
public class CustomerDto {

    private String name;
    private String customerCode;
    private String mail;
    private String phoneNumber;
    private String street;
    private String buildingNumber;
    private String city;
    private String postalCode;

}