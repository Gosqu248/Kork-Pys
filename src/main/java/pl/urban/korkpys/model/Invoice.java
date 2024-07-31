package pl.urban.korkpys.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String image;

    private String invoiceMonth;

    private String invoiceYear;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}