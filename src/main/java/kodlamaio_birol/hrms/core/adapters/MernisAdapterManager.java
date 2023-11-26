package kodlamaio_birol.hrms.core.adapters;

import kodlamaio_birol.hrms.core.services.HumanChecker;
import kodlamaio_birol.hrms.entities.concretes.JobSeeker;
import kodlamaio_birol.hrms.mernisService.JHPKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisAdapterManager implements HumanChecker {


    public boolean isValid(JobSeeker jobSeeker) {
        boolean result=false;
        JHPKPSPublicSoap soap=new JHPKPSPublicSoap();

        try{
            result=soap.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()),
                    jobSeeker.getFirstName().toUpperCase(),
                    jobSeeker.getLastName().toUpperCase(),
                    jobSeeker.getBirthDate().getYear());
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }
}