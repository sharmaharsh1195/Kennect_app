
package  com.wellfound.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellfound.entity.Post;
import com.wellfound.entity.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p")
    List<Post> showAllPost();
    
    List<Post> findAllByUser(User user);
}
