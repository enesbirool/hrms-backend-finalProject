package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getEmployerById(int id);

    @Transactional
    void deleteEmployerById(int id);
}
