package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.CurriculaVitaeService;
import kodlamaio_birol.hrms.core.helpers.CloudinaryService;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.CurriculaVitaeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio_birol.hrms.entities.concretes.CurriculaVitae;

import java.io.IOException;

@Service
public class CurriculaVitaeManager implements CurriculaVitaeService {

    private final CurriculaVitaeDao curriculaVitaeDao;

    private final CloudinaryService cloudinaryService;

    @Autowired
    public CurriculaVitaeManager(CurriculaVitaeDao curriculaVitaeDao, CloudinaryService cloudinaryService) {
        this.curriculaVitaeDao = curriculaVitaeDao;
        this.cloudinaryService = cloudinaryService;

    }

    @Override
    public Result addCv(CurriculaVitae curriculaVitae) {
        this.curriculaVitaeDao.save(curriculaVitae);
        return new SuccessResult("Success: Cv başarıyla eklendi!");
    }


    @Override
    public DataResult<CurriculaVitae> findByJobSeekerId(int jobseekerId) {
        if (this.curriculaVitaeDao.findByJobSeekerId(jobseekerId) == null) {
            return new ErrorDataResult<>("Warning: Kayıtlı Cv bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.curriculaVitaeDao.findByJobSeekerId(jobseekerId),
                    "Success: Cv'ler başarıyla listelendi!");
        }
    }

    @Override
    public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.addPicture(file);
        var url = result.getData().get("url");

        CurriculaVitae ref = this.curriculaVitaeDao.getOne(cvId);
        ref.setPictureUrl(url.toString());
        this.curriculaVitaeDao.save(ref);

        return new SuccessResult("Success: Resim ekleme işlemi başarılı!");
    }
}