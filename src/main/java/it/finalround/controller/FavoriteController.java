
package it.finalround.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import it.finalround.service.FavoriteService;
import it.finalround.mapper.ArticleMapperEnhanced;
import it.finalround.dto.PostSummaryDto;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FavoriteController {

   private final FavoriteService service;
   private final ArticleMapperEnhanced mapper;

   @PatchMapping("/posts/{postId}/favorite")
   public void toggle(@PathVariable Long postId, @RequestParam Long userId){
       service.toggle(postId,userId);
   }

   @GetMapping("/users/{userId}/favorites")
   public List<PostSummaryDto> favorites(@PathVariable Long userId){
       return service.listFavorites(userId).stream().map(mapper::toSummary).toList();
   }
}
