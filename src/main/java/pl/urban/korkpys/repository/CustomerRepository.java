package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urban.korkpys.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
