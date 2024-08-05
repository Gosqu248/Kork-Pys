package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.urban.korkpys.model.Invoice;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @EntityGraph(attributePaths = {"items"})
    List<Invoice> findByPurchasingPartyStreetAndPurchasingPartyBuildingNumber(String street, String buildingNumber);


}