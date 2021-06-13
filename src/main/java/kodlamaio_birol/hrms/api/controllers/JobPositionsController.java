package kodlamaio_birol.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.JobPositionService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getpositions")
    public DataResult<List<JobPosition>> getPositions() {
        return this.jobPositionService.getPositions();
    }

    @PostMapping("/addposition")
    public Result addJobPosition(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.addJobPosition(jobPosition);
    }
}