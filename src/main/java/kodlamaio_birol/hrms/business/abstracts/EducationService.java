package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    Result addEducation(Education education);

    DataResult<List<Education>> getAllEducations();

    DataResult<List<Education>> getEducationsByCvId(int id);
}
