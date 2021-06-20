package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker getJobSeekerById(int id);

    List<JobSeeker> findByEmail(String email);

    @Transactional
    void deleteJobSeekerById(int id);
}