package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.LanguageService;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getLanguages")
    public DataResult<List<Language>> getLanguages() {
        return this.languageService.getLanguages();
    }

    @PostMapping("/addLanguages")
    public DataResult<List<Language>> addLanguages(@RequestBody List<Language> languages) {
        return this.languageService.addLanguages(languages);
    }
}
