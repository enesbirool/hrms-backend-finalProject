package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.SystemPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface SystemPeronelDao extends JpaRepository<SystemPersonel, Integer> {
    SystemPersonel getSystemPersonelById(int id);

    @Transactional
    void deleteSystemPersonelById(int id);
}
