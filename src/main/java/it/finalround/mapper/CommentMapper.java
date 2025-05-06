package it.finalround.mapper;

import it.finalround.dto.CommentDto;
import it.finalround.entity.Comment;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CommentMapper {

   /* mapping con conteggio like/dislike */
   @Mapping(target = "likes",
           expression = "java( countLikes(c, 1) )")
   @Mapping(target = "dislikes",
           expression = "java( countLikes(c, 0) )")
   CommentDto toDto(Comment c);

   /* ===== helper ===== */
   default Integer countLikes(Comment c, int type) {
      if (c.getLikes() == null) return 0;
      return (int) c.getLikes()
              .stream()
              .filter(l -> l.getType() != null && l.getType() == type)
              .count();
   }
}
