package pl.urban.korkpys.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Setter
@Getter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mail;
    private String phoneNumber;
    private String street;
    private String buildingNumber;
    private String city;
    private String postalCode;
    private String customerCode;
    private String password;

    public void setPassword(String street, String buildingNumber, BCryptPasswordEncoder encoder) {
        String rawPassword = street + buildingNumber;
        this.password = encoder.encode(rawPassword);
    }

    public void setPassword(String newPassword, BCryptPasswordEncoder encoder) {
        this.password = encoder.encode(newPassword);
    }
}
