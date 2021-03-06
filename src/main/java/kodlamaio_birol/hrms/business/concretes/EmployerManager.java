package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.EmployerService;
import kodlamaio_birol.hrms.core.helpers.CloudinaryService;
import kodlamaio_birol.hrms.core.utilities.EmailValidator;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio_birol.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;

    private final CloudinaryService cloudinaryService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, CloudinaryService cloudinaryService) {
        this.employerDao = employerDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public DataResult<List<Employer>> getEmployers() {
        if ((long) this.employerDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.employerDao.findAll(), "Success: İş Verenler listelendi!");
        }

        return new ErrorDataResult<>(this.employerDao.findAll(), "Warning: Herhangi bir iş veren bulunamadı!");
    }

    @Override
    public Result addEmployer(Employer employer) {
        String[] employerWebsite = employer.getWebsite().split("\\.", 2);
        String website = employerWebsite[1];

        String[] employerEmail = employer.getEmail().split("@");
        String employerDomain = employerEmail[1];
        try {
            if (!EmailValidator.emailFormatController(employer.getEmail())) {
                return new ErrorResult("Error: Mail formata uygun değil!");
            } else if (!employerDomain.equals(website)) {
                return new ErrorResult("Error: Web sitesi ile email aynı domaine sahip değil!");
            } else if (!employer.getPassword().equals(employer.getConfirmPassword())) {
                return new ErrorResult("Error: Girmiş olduğunuz şifreler uyuşmuyor!");
            } else {
                this.employerDao.save(employer);
                return new SuccessResult(
                        "Success: İş veren kullanıcı sisteme eklendi, Doğrulama kodu email adresinize gönderildi!");
            }
        } catch (Exception e) {
            if (e.getMessage()
                 .contains("[uc_users_email]")) {
                return new ErrorResult("Error: Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
            } else {
                return new ErrorResult("Error: Şirket adı sistem de kayıtlı, lütfen başka bir Şirket adı giriniz!");
            }
        }
    }

    @Override
    public Result deleteEmployerById(int employerId) {
        this.employerDao.deleteEmployerById(employerId);
        return new SuccessResult("Success: Şirket silindi!");
    }

    @Override
    public DataResult<Employer> getEmployerById(int employerId) {
        if (this.employerDao.getEmployerById(employerId) == null) {
            return new ErrorDataResult<>("Warning: Kayıtlı Şirket bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.employerDao.getEmployerById(employerId),
                    "Success: Şirket başarıyla listelendi!");
        }
    }

    @Override
    public Result uploadPicture(int employerId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.addPicture(file);
        var url = result.getData().get("url");

        Employer ref = this.employerDao.getOne(employerId);
        ref.setPictureUrl(url.toString());
        this.employerDao.save(ref);

        return new SuccessResult("Success: Resim ekleme işlemi başarılı!");
    }
}
