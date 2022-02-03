package reeksamentwitter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import reeksamentwitter.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    /*
    @Query(value = "SELECT * FROM posts_hashtagsset WHERE hashtag_id = ?;", nativeQuery = true)
    List<Post> findPostsByHashtag(Long hashtag);

     */
}
