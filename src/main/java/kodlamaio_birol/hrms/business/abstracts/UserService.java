package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.Technologie;
import kodlamaio_birol.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {
    User findByEmail(String Email);

}
