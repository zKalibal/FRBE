
package it.finalround.mapper;
import org.mapstruct.*;
import it.finalround.dto.PostSummaryDto;
import it.finalround.entity.Article;
@Mapper(componentModel="spring")
public interface ArticleMapper{
  PostSummaryDto toSummary(Article a);
}
