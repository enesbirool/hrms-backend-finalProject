package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.EducationService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
    private final EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getEducations")
    public DataResult<List<Education>> getEducations() {
        return this.educationService.getAllEducations();
    }

    @GetMapping("/getEducationsByCvId")
    public DataResult<List<Education>> getEducationsByCvId(@RequestParam int cvId) {
        return this.educationService.getEducationsByCvId(cvId);
    }

    @PostMapping("/addEducation")
    public Result addEducation(@RequestBody Education education) {
        return this.educationService.addEducation(education);
    }
}
