
package it.finalround.repository;

import it.finalround.entity.Favorite;
import it.finalround.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite,Long>{
   List<Favorite> findByUserId(Long userId);
   Optional<Favorite> findByPostIdAndUserId(Long postId, Long userId);
   long countByPost(Article post);
}
