package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker getJobSeekerById(int id);

    @Transactional
    void deleteJobSeekerById(int id);
}