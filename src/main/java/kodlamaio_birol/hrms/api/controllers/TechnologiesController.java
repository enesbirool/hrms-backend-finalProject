package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.Technologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.TechnologieService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
@CrossOrigin
public class TechnologiesController {

    private final TechnologieService technologieService;

    @Autowired
    public TechnologiesController(TechnologieService technologieService) {
        this.technologieService = technologieService;
    }

    @GetMapping("/getProgrammingLanguages")
    public DataResult<List<Technologie>> getProgrammingLanguages() {
        return this.technologieService.getAllProgrammingLanguage();
    }

    @PostMapping("/addProgrammingLanguage")
    public Result addProgrammingLanguage(@RequestBody Technologie pl) {
        return this.technologieService.addProgrammingLanguage(pl);
    }
}
