
package it.finalround.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import it.finalround.service.CommentService;
import it.finalround.mapper.CommentMapper;
import it.finalround.dto.CommentDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommentController {

   private final CommentService service;
   private final CommentMapper mapper;

   @GetMapping("/posts/{postId}/comments")
   public Page<CommentDto> list(@PathVariable Long postId, Pageable pageable){
       return service.list(postId,pageable).map(mapper::toDto);
   }

   static record NewComment(@NotBlank String comment, Long parentId, @NotNull Long userId){}

   @PostMapping("/posts/{postId}/comments")
   public CommentDto add(@PathVariable Long postId, @RequestBody NewComment body){
       return mapper.toDto(service.add(postId, body.comment(), body.userId(), body.parentId()));
   }

   @PatchMapping("/comments/{id}/like")
   public CommentDto toggleLike(@PathVariable Long id,
                                @RequestParam int type,
                                @RequestParam Long userId){
       return mapper.toDto(service.toggleLike(id, userId, type));
   }
}
