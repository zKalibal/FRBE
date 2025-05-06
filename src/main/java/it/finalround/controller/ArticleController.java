
package it.finalround.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import it.finalround.dto.PostSummaryDto;
import it.finalround.enums.ArticleType;
import it.finalround.mapper.ArticleMapper;
import it.finalround.service.ArticleService;
@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class ArticleController{
  private final ArticleService service;
  private final ArticleMapper mapper;
  @GetMapping
  public Page<PostSummaryDto> all(
        @RequestParam(required=false) ArticleType type,
        @RequestParam(required=false) Long platformId,
        @RequestParam(required=false) Long authorId,
        @RequestParam(required=false) Long rubricId,
        @RequestParam(required=false) String search,
        Pageable pageable){
      return service.list(type,platformId,authorId,rubricId,search,pageable)
                    .map(mapper::toSummary);
  }
}
