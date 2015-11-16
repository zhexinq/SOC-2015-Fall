package models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Repository to achieve post CRUD functions
 * Created by qiuzhexin on 11/5/15.
 */

public interface PostRepository extends CrudRepository<Post, Long> {
    // find post by user
    List<Post> findAllByUser(User user);
    // get all posts given a user id in time descending order
    @Query(value = "select p.* from Post p, User u where p.creatorId=u.id order by p.createTime desc", nativeQuery = true)
    List<Post> getPostByUserOrderByCreateTimeDesc();
}