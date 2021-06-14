package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.entities.concretes.City;
import kodlamaio_birol.hrms.entities.concretes.Department;
import java.util.List;

public interface CityService {
    DataResult<List<City>> getAllCity();
}
