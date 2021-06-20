package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.JobSeekerService;
import kodlamaio_birol.hrms.business.constants.Messages;
import kodlamaio_birol.hrms.core.services.HumanChecker;
import kodlamaio_birol.hrms.core.services.MernisCheckService;
import kodlamaio_birol.hrms.core.utilities.EmailValidator;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio_birol.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private final JobSeekerDao jobSeekerDao;
    private final MernisCheckService mernisCheckService;
    private final HumanChecker humanChecker;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService, HumanChecker humanChecker) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisCheckService = mernisCheckService;
        this.humanChecker = humanChecker;
    }

    @Override
    public DataResult<List<JobSeeker>> getJobSeekers() {
        if ((long) this.jobSeekerDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "Success: İş Arayanlar listelendi!");
        }

        return new ErrorDataResult<>(this.jobSeekerDao.findAll(), "Warning: Herhangi bir iş arayan bulunamadı!");
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        try {
            if (!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
                return new ErrorResult(Messages.EmailFormatError);
            }else if(!humanChecker.isValid(jobSeeker)){
                return new ErrorResult(Messages.HumanIdentityError);
            }
            else {
                this.jobSeekerDao.save(jobSeeker);
                return new SuccessResult(Messages.JobSeekerAddedSuccess);
            }
        }catch (Exception e){
            if (e.getMessage()
                    .equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorResult(Messages.ExistEMailError);
            } else {
                return new ErrorResult(Messages.JobSeekerAddErrorHumanIdentity);
            }

        }
    }

    @Override
    public Result deleteJobSeekerById(int jobSeekerId) {
        this.jobSeekerDao.deleteJobSeekerById(jobSeekerId);
        return new SuccessResult("Success: İş arayan silindi!");
    }

    @Override
    public DataResult<JobSeeker> getJobSeekerById(int jobSeekerId) {
        if (this.jobSeekerDao.getJobSeekerById(jobSeekerId) == null) {
            return new ErrorDataResult<>("Warning: Kayıtlı İş Arayan bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.jobSeekerDao.getJobSeekerById(jobSeekerId),
                    "Success: İş Arayan listelendi!");
        }
    }


}