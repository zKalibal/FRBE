
package it.finalround.spec;
import it.finalround.entity.Article;
import it.finalround.enums.ArticleType;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
public class ArticleSpecification{
  public static Specification<Article> hasType(ArticleType type){
    return (root, query, cb) -> type==null?cb.conjunction():cb.equal(root.get("type"), type);
  }
  public static Specification<Article> hasPlatform(Long platformId){
    return (root, query, cb) -> {
      if(platformId==null) return cb.conjunction();
      Join<Object,Object> pl = root.joinSet("platforms");
      return cb.equal(pl.get("id"), platformId);
    };
  }
  public static Specification<Article> hasRubric(Long rubricId){
    return (root, query, cb) -> rubricId==null?cb.conjunction():cb.equal(root.get("rubric").get("id"), rubricId);
  }
  public static Specification<Article> hasAuthor(Long authorId){
    return (root, query, cb) -> authorId==null?cb.conjunction():cb.equal(root.get("author").get("id"), authorId);
  }
  public static Specification<Article> search(String q){
    return (root, query, cb) -> {
      if(q==null || q.isBlank()) return cb.conjunction();
      String pattern = "%" + q.toLowerCase() + "%";
      return cb.or(cb.like(cb.lower(root.get("title")), pattern),
                   cb.like(cb.lower(root.get("shortDescription")), pattern));
    };
  }
}
