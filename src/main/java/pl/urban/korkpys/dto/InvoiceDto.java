package pl.urban.korkpys.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDto {

    @JsonProperty("Id")
    private Long id;
    @JsonProperty("NetTotal")
    private double netTotal;
    @JsonProperty("CurrencyNetTotal")
    private double currencyNetTotal;
    @JsonProperty("GrossTotal")
    private double grossTotal;
    @JsonProperty("CurrencyGrossTotal")
    private double currencyGrossTotal;
    @JsonProperty("VatTotal")
    private double vatTotal;
    @JsonProperty("CurrencyVatTotal")
    private double currencyVatTotal;
    @JsonProperty("CurrencyCode")
    private String currencyCode;
    @JsonProperty("CurrencyRateType")
    private int currencyRateType;
    @JsonProperty("CurrencyRateDate")
    private OffsetDateTime currencyRateDate;
    @JsonProperty("CurrencyConverter")
    private double currencyConverter;
    @JsonProperty("CurrencyRate")
    private double currencyRate;
    @JsonProperty("PaymentStatus")
    private int paymentStatus;
    @JsonProperty("OSSProcedureCountryCode")
    private String ossProcedureCountryCode;
    @JsonProperty("IsOSSProcedure")
    private boolean isOssProcedure;
    @JsonProperty("IsFinal")
    private boolean isFinal;
    @JsonProperty("PurchasingParty")
    private PartyDto purchasingParty;
    @JsonProperty("PaymentTypeId")
    private int paymentTypeId;
    @JsonProperty("PaymentType")
    private int paymentType;
    @JsonProperty("PaymentDeadline")
    private OffsetDateTime paymentDeadline;
    @JsonProperty("BankAccountId")
    private Long bankAccountId;
    @JsonProperty("BankAccountNumber")
    private String bankAccountNumber;
    @JsonProperty("SalesDate")
    private OffsetDateTime salesDate;
    @JsonProperty("InvoiceType")
    private int invoiceType;
    @JsonProperty("Items")
    private List<InvoiceItemDto> items;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("IssueDate")
    private OffsetDateTime issueDate;
    @JsonProperty("Number")
    private String number;
    @JsonProperty("Status")
    private int status;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PartyDto {
        @JsonProperty("Name")
        private String name;
        @JsonProperty("NipPrefix")
        private String nipPrefix;
        @JsonProperty("Nip")
        private String nip;
        @JsonProperty("Country")
        private String country;
        @JsonProperty("City")
        private String city;
        @JsonProperty("Street")
        private String street;
        @JsonProperty("BuildingNumber")
        private String buildingNumber;
        @JsonProperty("FlatNumber")
        private String flatNumber;
        @JsonProperty("BankName")
        private String bankName;
        @JsonProperty("BankAccountNumber")
        private String bankAccountNumber;
        @JsonProperty("CustomerType")
        private int customerType;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InvoiceItemDto {
        @JsonProperty("Id")
        private Long id;
        @JsonProperty("ProductId")
        private Long productId;
        @JsonProperty("Quantity")
        private double quantity;
        @JsonProperty("ProductCurrencyPrice")
        private double productCurrencyPrice;
        @JsonProperty("ProductPrice")
        private double productPrice;
        @JsonProperty("ProductName")
        private String productName;
        @JsonProperty("ProductDescription")
        private String productDescription;
        @JsonProperty("UnitOfMeasurement")
        private String unitOfMeasurement;
        @JsonProperty("VatRateId")
        private int vatRateId;
    }
}