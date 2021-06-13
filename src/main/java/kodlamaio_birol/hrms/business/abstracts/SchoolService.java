package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result addSchool(School school);

    DataResult<List<School>> getAllSchool();
}
