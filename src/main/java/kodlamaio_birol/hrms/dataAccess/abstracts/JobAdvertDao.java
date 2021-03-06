package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.JobAdvert;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
    List<JobAdvert> findAllByIsActiveTrue();

    List<JobAdvert> getJobAdvertByIsActiveTrueAndEmployer_CompanyName(String companyName);

    List<JobAdvert> findAllByIsActiveTrue(Sort sort);

    List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(Sort sort);

    @Transactional
    @Modifying
    @Query("Update JobAdvert set isActive =:active where id =:jobAdvertId")
    void changeIsActive(boolean active, int jobAdvertId);

    @Transactional
    @Modifying
    @Query("Update JobAdvert set isConfirmed =:confirm where id =:jobAdvertId")
    void changeIsConfirmed(boolean confirm, int jobAdvertId);

    JobAdvert getJobAdvertById(int id);

    @Transactional
    void deleteJobAdvertById(int id);
}
