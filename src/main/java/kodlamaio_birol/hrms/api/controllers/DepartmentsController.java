package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.DepartmentService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class DepartmentsController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getDepartments")
    public DataResult<List<Department>> getDepartments() {
        return this.departmentService.getAllDepartment();
    }

    @PostMapping("/addDepartment")
    public Result addDepartment(@RequestBody Department department) {
        return this.departmentService.addDepartment(department);
    }
}
