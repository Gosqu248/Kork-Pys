package pl.urban.korkpys.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String mail;
    private String phoneNumber;
    private String customerCode;
}
