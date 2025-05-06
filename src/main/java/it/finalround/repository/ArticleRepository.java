
package it.finalround.repository;
import it.finalround.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface ArticleRepository extends JpaRepository<Article,Long>, JpaSpecificationExecutor<Article>{}
