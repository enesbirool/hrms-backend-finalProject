package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.Employer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getEmployers();

    Result addEmployer(Employer employer);

    Result deleteEmployerById(int employerId);

    DataResult<Employer> getEmployerById(int employerId);

    Result uploadPicture(int employerId, MultipartFile file) throws IOException;
}
