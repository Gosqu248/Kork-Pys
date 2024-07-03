package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urban.korkpys.model.EcoServices;

public interface EcoServicesRepository extends JpaRepository<EcoServices, Long> {
}