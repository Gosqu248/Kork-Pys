package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.urban.korkpys.model.Invoice;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @EntityGraph(attributePaths = {"items"})
    @Query("SELECT i FROM Invoice i WHERE LOWER(i.purchasingParty.street) = LOWER(:street) AND i.purchasingParty.buildingNumber = :buildingNumber")
    List<Invoice> findByPurchasingPartyStreetAndPurchasingPartyBuildingNumber(@Param("street") String street, @Param("buildingNumber") String buildingNumber);

    Optional<Invoice> findByNumber(String number);
    boolean existsByNumber(String number);
}