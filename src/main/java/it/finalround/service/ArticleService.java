
package it.finalround.service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import it.finalround.repository.ArticleRepository;
import it.finalround.spec.ArticleSpecification;
import it.finalround.enums.ArticleType;
@Service
@RequiredArgsConstructor
public class ArticleService{
  private final ArticleRepository repo;
  public Page<it.finalround.entity.Article> list(ArticleType type, Long platformId, Long authorId, Long rubricId, String search, Pageable pageable){
      var spec = ArticleSpecification.hasType(type)
                 .and(ArticleSpecification.hasPlatform(platformId))
                 .and(ArticleSpecification.hasAuthor(authorId))
                 .and(ArticleSpecification.hasRubric(rubricId))
                 .and(ArticleSpecification.search(search));
      return repo.findAll(spec, pageable);
  }
}
