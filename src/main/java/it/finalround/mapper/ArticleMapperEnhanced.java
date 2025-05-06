
package it.finalround.mapper;

import org.mapstruct.*;
import lombok.RequiredArgsConstructor;
import it.finalround.dto.PostSummaryDto;
import it.finalround.entity.Article;
import it.finalround.service.FavoriteService;
@Mapper(componentModel="spring")
public abstract class ArticleMapperEnhanced {

   @org.springframework.beans.factory.annotation.Autowired
   protected FavoriteService favoriteService;

   @Mapping(target="favoritesCount", expression="java( (int)favoriteService.countFavorites(a) )")
   public abstract PostSummaryDto toSummary(Article a);
}
