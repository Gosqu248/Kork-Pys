package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urban.korkpys.model.ConstructionEquipment;

public interface ConstructionEquipmentRepository extends JpaRepository<ConstructionEquipment, Long> {
    boolean existsByTitle(String title);

}