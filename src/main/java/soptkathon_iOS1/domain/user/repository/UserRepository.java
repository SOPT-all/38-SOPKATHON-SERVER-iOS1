package soptkathon_iOS1.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soptkathon_iOS1.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
