
package it.finalround.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import it.finalround.repository.PlatformRepository;
import it.finalround.mapper.PlatformMapper;
import it.finalround.dto.PlatformDto;
@RestController
@RequestMapping("/api/v1/platforms")
@RequiredArgsConstructor
public class PlatformController{
  private final PlatformRepository repo;
  private final PlatformMapper mapper;
  @GetMapping
  public List<PlatformDto> all(){
    return repo.findAll().stream().map(mapper::toDto).toList();
  }
}
