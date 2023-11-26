package kodlamaio_birol.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio_birol.hrms.entities.concretes.CurriculaVitae;

public interface CurriculaVitaeDao extends JpaRepository<CurriculaVitae, Integer> {

    CurriculaVitae findByJobSeekerId(int id);
}
