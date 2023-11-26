package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.SchoolService;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio_birol.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result addSchool(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Success: Okul başarıyla eklendi!");
    }

    @Override
    public DataResult<List<School>> getAllSchool() {
        if (this.schoolDao.findAll().isEmpty()) {
            return new ErrorDataResult<>("Warning: Kayıtlı okul bulunamadı!");
        } else {
            return new SuccessDataResult<>(this.schoolDao.findAll(), "Success: Bütün okullar başarıyla listelendi!");
        }
    }
}
