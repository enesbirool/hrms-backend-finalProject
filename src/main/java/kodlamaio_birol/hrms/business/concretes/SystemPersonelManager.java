package kodlamaio_birol.hrms.business.concretes;

import kodlamaio_birol.hrms.business.abstracts.SystemPersonelService;
import kodlamaio_birol.hrms.core.utilities.results.*;
import kodlamaio_birol.hrms.dataAccess.abstracts.SystemPeronelDao;
import kodlamaio_birol.hrms.entities.concretes.SystemPersonel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonelManager implements SystemPersonelService {

    SystemPeronelDao systemPeronelDao;

    public SystemPersonelManager(SystemPeronelDao systemPeronelDao) {
        this.systemPeronelDao = systemPeronelDao;
    }

    @Override
    public DataResult<List<SystemPersonel>> getSystemPersonels() {
        if ((long) this.systemPeronelDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.systemPeronelDao.findAll(), "Success: Personeller listelendi!");
        }

        return new ErrorDataResult<>(this.systemPeronelDao.findAll(), "Warning: Herhangi bir personel bulunamadı!");
    }

    @Override
    public Result addSystemPersonel(SystemPersonel systemPersonel) {
        this.systemPeronelDao.save(systemPersonel);
        return new SuccessResult("Success: Personel başarıyla eklendi!");
    }

    @Override
    public DataResult<SystemPersonel> getSystemPersonelById(int systemPersonelId) {
        if (this.systemPeronelDao.getSystemPersonelById(systemPersonelId) == null) {
            return new ErrorDataResult<>("Warning: Kayıtlı Personel bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.systemPeronelDao.getSystemPersonelById(systemPersonelId),
                    "Success: Personel listelendi!");
        }

    }

    @Override
    public Result deleteSystemPersonelById(int systemPersonelId) {
        this.systemPeronelDao.deleteSystemPersonelById(systemPersonelId);
        return new SuccessResult("Success: Personel silindi!");
    }
}
