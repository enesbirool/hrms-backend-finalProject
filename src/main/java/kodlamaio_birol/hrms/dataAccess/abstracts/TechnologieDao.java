package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologieDao extends JpaRepository<Technologie, Integer> {
}
