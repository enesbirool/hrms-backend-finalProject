package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.CityService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio_birol.hrms.dataAccess.abstracts.CityDao;
import kodlamaio_birol.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private final CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAllCity() {
        return new SuccessDataResult<>(this.cityDao.findAll());
    }
}
