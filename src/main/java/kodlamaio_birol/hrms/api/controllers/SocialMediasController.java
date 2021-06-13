package kodlamaio_birol.hrms.api.controllers;

import kodlamaio_birol.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio_birol.hrms.business.abstracts.SocialMediaService;
import kodlamaio_birol.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/socialmedias")
@CrossOrigin
public class SocialMediasController {

    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediasController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @PostMapping("/addSocialMedia")
    public Result addSocialMedia(@RequestBody SocialMedia socialMedia) {
        return this.socialMediaService.addSocialMedia(socialMedia);
    }
}
