package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.City;
import kodlamaio_birol.hrms.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
