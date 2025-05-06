
package it.finalround.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import it.finalround.repository.RubricRepository;
import it.finalround.mapper.RubricMapper;
import it.finalround.dto.RubricDto;
@RestController
@RequestMapping("/api/v1/rubrics")
@RequiredArgsConstructor
public class RubricController{
  private final RubricRepository repo;
  private final RubricMapper mapper;
  @GetMapping
  public List<RubricDto> all(){
    return repo.findAll().stream().map(mapper::toDto).toList();
  }
}
