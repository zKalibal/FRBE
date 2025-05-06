
package it.finalround.dto;

import lombok.*;
import java.time.Instant;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CommentDto{
   private Long id;
   private Long userId;
   private String comment;
   private Instant date;
   private Integer likes;
   private Integer dislikes;
   private List<CommentDto> replies;
}
