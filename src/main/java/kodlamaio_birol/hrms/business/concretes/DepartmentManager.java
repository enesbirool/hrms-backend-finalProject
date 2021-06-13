package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.DepartmentService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.core.utilities.results.SuccessResult;
import kodlamaio_birol.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio_birol.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Result addDepartment(Department department) {
        this.departmentDao.save(department);
        return new SuccessResult("Success: Bölüm başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Department>> getAllDepartment() {
        if (this.departmentDao.findAll().isEmpty()) {
            return new ErrorDataResult<>("Warning: Kayıtlı bölüm bulunamadı!");
        } else {
            return new DataResult<>(this.departmentDao.findAll(), "Success: Bölümler başarıyla listelendi!");
        }
    }
}
