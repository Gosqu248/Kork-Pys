package pl.urban.korkpys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urban.korkpys.model.Images;

public interface ImagesRepository extends JpaRepository<Images, Long> {
}
