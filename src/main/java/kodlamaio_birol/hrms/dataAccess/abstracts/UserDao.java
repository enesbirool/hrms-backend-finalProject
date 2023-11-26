package kodlamaio_birol.hrms.dataAccess.abstracts;

import kodlamaio_birol.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
