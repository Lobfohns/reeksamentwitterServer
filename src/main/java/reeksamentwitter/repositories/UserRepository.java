package reeksamentwitter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reeksamentwitter.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
