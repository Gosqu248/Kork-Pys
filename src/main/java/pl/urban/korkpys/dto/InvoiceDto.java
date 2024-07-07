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

}
