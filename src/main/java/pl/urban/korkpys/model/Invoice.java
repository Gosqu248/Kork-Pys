package pl.urban.korkpys.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double netTotal;
    private double currencyNetTotal;
    private double grossTotal;
    private double currencyGrossTotal;
    private double vatTotal;
    private double currencyVatTotal;
    private String currencyCode;
    private int currencyRateType;
    private OffsetDateTime currencyRateDate;
    private double currencyConverter;
    private double currencyRate;
    private int paymentStatus;
    private String ossProcedureCountryCode;
    private boolean isOssProcedure;
    private boolean isFinal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "purchasing_party_id")
    private Party purchasingParty;

    private int paymentTypeId;
    private int paymentType;
    private OffsetDateTime paymentDeadline;
    private Long bankAccountId;
    private String bankAccountNumber;
    private OffsetDateTime salesDate;
    private int invoiceType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items = new ArrayList<>();

    private String description;
    private OffsetDateTime issueDate;
    private String number;
    private int status;

    @Getter
    @Setter
    @Entity
    @Table(name = "invoice_items")
    public static class InvoiceItem {

        @Id
        private Long id;

        private long productId;
        private double quantity;
        private double productCurrencyPrice;
        private double productPrice;
        private String productName;
        @Column(name="product_description", length = 500)
        private String productDescription;
        private String unitOfMeasurement;
        private int vatRateId;
    }
}