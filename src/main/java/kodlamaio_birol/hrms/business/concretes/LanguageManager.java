package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.LanguageService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio_birol.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio_birol.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio_birol.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> addLanguages(List<Language> languages) {
        return new SuccessDataResult<>(
                this.languageDao.saveAll(languages),
                "Success: Yabancı dil ekleme işlemi başarılı!");
    }

    @Override
    public DataResult<List<Language>> getLanguages() {
        if (this.languageDao.findAll().isEmpty()) {
            return new ErrorDataResult<>("Warning: Kayıtlı yabancı dil bulunamadı!");
        }
        return new SuccessDataResult<>(this.languageDao.findAll(), "Success: Yabancı diller başarıyla listelendi!");

    }
}
