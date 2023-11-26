package kodlamaio_birol.hrms.core.utilities;
import kodlamaio_birol.hrms.business.abstracts.UserService;
import kodlamaio_birol.hrms.dataAccess.abstracts.UserDao;
import kodlamaio_birol.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {

    @Autowired
    UserDao userDao;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        User user=userDao.findByEmail(email);
        if(email!=null){
            return false;
        }
        return true;

    }
}
