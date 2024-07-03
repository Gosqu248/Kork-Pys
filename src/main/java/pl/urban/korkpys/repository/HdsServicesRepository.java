package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urban.korkpys.model.HdsServices;

public interface HdsServicesRepository extends JpaRepository<HdsServices, Long> {
}