package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.Technologie;

import java.util.List;

public interface TechnologieService {
    Result addProgrammingLanguage(Technologie pl);

    DataResult<List<Technologie>> getAllProgrammingLanguage();
}
