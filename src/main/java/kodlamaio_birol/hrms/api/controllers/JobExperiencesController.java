package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.JobExperienceService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin
public class JobExperiencesController {

    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getJobExperienceByCvId")
    public DataResult<List<JobExperience>> getJobExperienceByCvId(@RequestParam int cvId) {
        return this.jobExperienceService.getJobExperienceByCvId(cvId);
    }

    @PostMapping("/addJobExperience")
    public Result addJobExperience(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.addJobExperience(jobExperience);
    }
}
