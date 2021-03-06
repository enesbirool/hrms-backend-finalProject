package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.JobAdvertService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getJobAdverts")
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return this.jobAdvertService.getJobAdverts();
    }

    @GetMapping("/getSortedJobAdverts")
    public DataResult<List<JobAdvert>> getSortedJobAdverts() {
        return this.jobAdvertService.getSortedJobAdverts();
    }

    @GetMapping("/getActiveJobAdverts")
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        return this.jobAdvertService.getActiveJobAdverts();
    }

    @GetMapping("/getJobAdvertByCompanyName")
    public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
        return this.jobAdvertService.getJobAdvertByCompanyName(companyName);
    }

    @GetMapping("/getActiveJobAdvertsSorted")
    public DataResult<List<JobAdvert>> findAllByIsActiveTrueSorted(@RequestParam boolean isDesc) {
        return this.jobAdvertService.findAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrue")
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(@RequestParam boolean isDesc) {
        return this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(isDesc);
    }

    @GetMapping("/getJobAdvertById")
    public DataResult<JobAdvert> getJobAdvertById(int jobAdvertId) {
        return this.jobAdvertService.getJobAdvertById(jobAdvertId);
    }

    @DeleteMapping("/deleteJobAdvertById")
    public Result deleteJobAdvertById(@RequestParam int jobAdvertId) {
        return this.jobAdvertService.deleteJobAdvertById(jobAdvertId);
    }

    @PostMapping("/addJobadvert")
    public Result addJobAdverts(@RequestBody JobAdvert jobAdvert) {
        return this.jobAdvertService.addJobAdvert(jobAdvert);
    }

}
