package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.JobAdvertService;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio_birol.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {
    private final JobAdvertDao jobAdvertsDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertsDao) {
        this.jobAdvertsDao = jobAdvertsDao;
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdverts() {
        if ((long) this.jobAdvertsDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "Success: Tüm iş ilanları listelendi.");
        }
        return new ErrorDataResult<>(this.jobAdvertsDao.findAll(), "Warning: Herhangi bir iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getSortedJobAdverts() {
        Sort sort = Sort.by(Sort.Direction.DESC, "airdate");
        return new SuccessDataResult<>(
                this.jobAdvertsDao.findAll(sort),
                "Success: iş ilanları listelendi!");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue().size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(),
                    "Success: Aktif tüm iş ilanları listelendi!");
        }
        return new ErrorDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(),
                "Warning: Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
        if ((long) this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName).size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(
                    companyName), "Success: Şirket'e ait tüm ilanlar listelendi!");
        }

        return new ErrorDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName),
                "Warning: Şirket'e ait herhangi bir ilan bulunamadı!");

    }

    @Override
    public DataResult<List<JobAdvert>> findAllByIsActiveTrue(boolean isDesc) {
        Sort sort;
        if (isDesc) {
            sort = Sort.by(Sort.Direction.DESC, "airdate");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "airdate");

        }
        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                    "Success: Aktif tüm iş ilanları yayınlanma tarihine göre listelendi!");
        }
        return new ErrorDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                "Warning: Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(boolean isDesc) {
        Sort sort;
        if (isDesc) {
            sort = Sort.by(Sort.Direction.DESC, "airdate");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "airdate");

        }
        if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(sort),
                    "Success: Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre listelendi!");

        }
        return new ErrorDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(sort),
                "Warning: Onaylı ve Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<JobAdvert> getJobAdvertById(int jobAdvertId) {
        if (this.jobAdvertsDao.getJobAdvertById(jobAdvertId) == null) {
            return new ErrorDataResult<>("Warning: Kayıtlı İş İlanı bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertById(jobAdvertId),
                    "Success: İş İlanı listelendi!");
        }
    }

    @Override
    public Result changeIsActive(boolean active, int jobAdvertId) {
        this.jobAdvertsDao.changeIsActive(active, jobAdvertId);
        return new SuccessResult("Success: İlan aktiflik durumu değiştirildi!");
    }

    @Override
    public Result changeIsConfirmed(boolean confirm, int jobAdvertId) {
        this.jobAdvertsDao.changeIsConfirmed(confirm, jobAdvertId);
        return new SuccessResult("Success: İlan onay durumu değiştirildi!");
    }

    @Override
    public Result addJobAdvert(JobAdvert jobAdvert) {
        this.jobAdvertsDao.save(jobAdvert);
        return new SuccessResult("Success: İlan sisteme eklendi!");
    }

    @Override
    public Result deleteJobAdvertById(int jobAdvertId) {
        this.jobAdvertsDao.deleteJobAdvertById(jobAdvertId);
        return new SuccessResult("Success: İş ilanı silindi!");
    }
}
