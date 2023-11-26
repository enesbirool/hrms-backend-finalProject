package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.JobExperienceService;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio_birol.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public Result addJobExperience(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Success: Kariyer bilgisi başarıyla sisteme eklendi!");
    }

    @Override
    public DataResult<List<JobExperience>> getJobExperienceByCvId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        if (this.jobExperienceDao.getJobExperienceEndDateByCurriculaVitaeId(id, sort).isEmpty()) {
            return new ErrorDataResult<>("Warning: Listelenecek iş tecrübesi bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.jobExperienceDao.getJobExperienceEndDateByCurriculaVitaeId(id, sort),
                    "Success: İş tecrübeleri başarıyla sıralanıp listelendi!");
        }
    }
}
