package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.urban.korkpys.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
