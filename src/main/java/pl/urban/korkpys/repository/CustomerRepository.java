package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urban.korkpys.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByCustomerCode(String customerCode);
    Customer findByCustomerCode(String customerCode);

    Optional<Customer> findByMailOrPhoneNumber(String mail, String phoneNumber);
    Optional<Customer> findByMail(String email);

}
