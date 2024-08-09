package pl.urban.korkpys.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "invoice_parties")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nipPrefix;
    private String nip;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;
    private String flatNumber;
    private String bankName;
    private String bankAccountNumber;
    private int customerType;
}