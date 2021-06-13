package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    DataResult<List<JobSeeker>> getJobSeekers();

    Result addJobSeeker(JobSeeker jobSeeker);

    Result deleteJobSeekerById(int jobSeekerId);

    DataResult<JobSeeker> getJobSeekerById(int jobSeekerId);

}
