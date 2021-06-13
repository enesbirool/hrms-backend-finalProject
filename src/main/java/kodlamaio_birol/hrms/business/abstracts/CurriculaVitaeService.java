package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio_birol.hrms.entities.concretes.CurriculaVitae;

import java.io.IOException;

public interface CurriculaVitaeService {

    Result addCv(CurriculaVitae curriculaVitae);

//    DataResult<List<JobseekerWithCurriculaVitaeDto>> getJobSeekerWithCurriculaVitae(int id);

    DataResult<CurriculaVitae> findByJobSeekerId(int jobseekerId);

    //!addCvWithPicture yazılacak..
    Result uploadPicture(int cvId, MultipartFile file) throws IOException;
}
