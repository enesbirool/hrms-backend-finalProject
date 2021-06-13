package kodlamaio_birol.hrms.mernisValidator;

import kodlamaio_birol.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;
import kodlamaio_birol.hrms.core.services.MernisCheckService;

@Service
public class MernisValidatorManager implements MernisCheckService {

    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return jobSeeker.getIdentityNumber().length() == 11;
    }
}
