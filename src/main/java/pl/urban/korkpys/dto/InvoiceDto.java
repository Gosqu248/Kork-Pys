package pl.urban.korkpys.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvoiceDto {

    private Long id;
    private String image;
    private String invoiceMonth;
    private String invoiceYear;
    private Long customer_id;

    public InvoiceDto() {}

    public InvoiceDto(Long id, String image, String invoiceMonth, String invoiceYear, Long customer_id) {
        this.id = id;
        this.image = image;
        this.invoiceMonth = invoiceMonth;
        this.invoiceYear = invoiceYear;
        this.customer_id = customer_id;
    }
}
