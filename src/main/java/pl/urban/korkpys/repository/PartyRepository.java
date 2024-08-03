package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urban.korkpys.model.Party;

public interface PartyRepository extends JpaRepository<Party, Long> {
}