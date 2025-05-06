
package it.finalround.dto;
import java.time.LocalDateTime;
import it.finalround.enums.ArticleType;
import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor
public class PostSummaryDto{
  private Long id;
  private String title;
  private ArticleType type;
  private String shortDescription;
  private String authorName;
  private LocalDateTime date;
  private long commentsCount;
  private boolean favorite;
  private Integer favoritesCount;
}
