
package it.finalround.repository;
import it.finalround.entity.CommentLike;
import it.finalround.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface CommentLikeRepository extends JpaRepository<CommentLike,Long>{
   Optional<CommentLike> findByCommentIdAndUserId(Long commentId, Long userId);
   long countByCommentAndType(Comment comment,int type);
}
