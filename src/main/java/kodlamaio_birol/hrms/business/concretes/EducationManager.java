package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.EducationService;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio_birol.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result addEducation(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Success: Eğitim bilgileri başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Education>> getAllEducations() {
        if (this.educationDao.findAll().isEmpty()) {
            return new ErrorDataResult<>("Warning: Listelenecek bir eğitim bilgisi bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.educationDao.findAll(),
                    "Success: Tüm eğitim bilgileri başarıyla listelendi!");
        }
    }

    @Override
    public DataResult<List<Education>> getEducationsByCvId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        if (this.educationDao.getEducationEndDateByCurriculaVitaeId(id, sort).isEmpty()) {
            return new ErrorDataResult<>("Warning: Listelenecek eğitim bilgisi bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.educationDao.getEducationEndDateByCurriculaVitaeId(id, sort),
                    "Success: Eğitim geçmişi başarıyla sıralanıp listelendi!");
        }
    }
}
