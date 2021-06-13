package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.JobSeekerService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getJobseekers")
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return this.jobSeekerService.getJobSeekers();
    }

    @GetMapping("/getJobSeekerById")
    public DataResult<JobSeeker> getJobSeekerById(int jobSeekerId) {
        return this.jobSeekerService.getJobSeekerById(jobSeekerId);
    }

    @DeleteMapping("/deleteJobSeekerById")
    public Result deleteJobSeekerById(@RequestParam int jobSeekerId) {
        return this.jobSeekerService.deleteJobSeekerById(jobSeekerId);
    }

    @PostMapping("/addJobseeker")
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }


}
