package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio_birol.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobseekerLanguages")
@CrossOrigin
public class JobSeekerLanguagesController {
    private final JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @PostMapping("/addJobseekerLanguages")
    public Result addJobseekerLanguage(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguage);
    }
}
