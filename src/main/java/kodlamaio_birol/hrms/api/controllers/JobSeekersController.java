package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.JobSeekerService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> addJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.ok(this.jobSeekerService.addJobSeeker(jobSeeker)) ;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors=new HashMap<String, String>();
        for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
        return errors;
    }


}
