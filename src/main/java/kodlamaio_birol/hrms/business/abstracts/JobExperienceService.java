package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result addJobExperience(JobExperience jobExperience);

    DataResult<List<JobExperience>> getJobExperienceByCvId(int id);
}
