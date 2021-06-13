package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.SocialMediaService;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.core.utilities.results.SuccessResult;
import kodlamaio_birol.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio_birol.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaManager implements SocialMediaService {

    private final SocialMediaDao socialMediaDao;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao) {
        this.socialMediaDao = socialMediaDao;
    }

    @Override
    public Result addSocialMedia(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult("Success: Sosyal medya bağlantıları başarıyla sisteme eklendi!");
    }
}
