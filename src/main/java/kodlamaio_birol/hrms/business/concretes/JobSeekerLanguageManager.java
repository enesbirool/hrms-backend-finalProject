package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.core.utilities.results.SuccessResult;
import kodlamaio_birol.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio_birol.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private final JobSeekerLanguageDao jobSeekerLanguageDao;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
    }

    @Override
    public Result addJobSeekerLanguage(JobSeekerLanguage jobSeekerLanguage) {
        this.jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult("Success: Cv'ye başarıyla yabancı dil bilgisi eklendi!");
    }
}
