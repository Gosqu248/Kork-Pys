package pl.urban.korkpys.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.urban.korkpys.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    @Modifying
    @Transactional
    @Query("update Invoice i set i.image = ?2, i.invoiceMonth = ?3, i.invoiceYear = ?4 where i.id = ?1")
    void updateInvoice(Long id, String image, String invoiceMonth, String invoiceYear);

}
