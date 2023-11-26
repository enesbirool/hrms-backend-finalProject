package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {
    Result addDepartment(Department department);

    DataResult<List<Department>> getAllDepartment();
}
