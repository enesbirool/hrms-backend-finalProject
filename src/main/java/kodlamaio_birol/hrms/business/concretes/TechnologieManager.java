package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.TechnologieService;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.TechnologieDao;
import kodlamaio_birol.hrms.entities.concretes.Technologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TechnologieManager implements TechnologieService {

    private final TechnologieDao technologieDao;

    @Autowired
    public TechnologieManager(TechnologieDao technologieDao) {
        this.technologieDao = technologieDao;
    }

    @Override
    public Result addProgrammingLanguage(Technologie pl) {
        this.technologieDao.save(pl);
        return new SuccessResult("Success: Programlama dili başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Technologie>> getAllProgrammingLanguage() {
        if (this.technologieDao.findAll().isEmpty()) {
            return new ErrorDataResult<>("Warning: Kayıtlı bir programlama dili yok!");
        }
        return new SuccessDataResult<>(
                this.technologieDao.findAll(),
                "Success: Programlama dilleri başarıyla listelendi!");
    }
}
