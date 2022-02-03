package reeksamentwitter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reeksamentwitter.models.Hashtag;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}
