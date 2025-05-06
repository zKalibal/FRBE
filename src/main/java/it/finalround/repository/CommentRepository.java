
package it.finalround.repository;
import it.finalround.entity.Comment;
import it.finalround.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepository extends JpaRepository<Comment,Long>{
   Page<Comment> findByPostAndParentIsNullOrderByDateDesc(Article post, Pageable pageable);
}
