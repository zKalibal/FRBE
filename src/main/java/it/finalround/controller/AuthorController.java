package it.finalround.controller;

import it.finalround.dto.AuthorDto;
import it.finalround.mapper.AuthorMapper;
import it.finalround.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;
    private final AuthorMapper mapper;

    @GetMapping
    public List<AuthorDto> list(){
        return service.list().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public AuthorDto get(@PathVariable Long id){
        return mapper.toDto(service.get(id));
    }

    @PostMapping
    public AuthorDto create(@RequestBody AuthorDto dto){
        return mapper.toDto(service.save(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public AuthorDto update(@PathVariable Long id, @RequestBody AuthorDto dto){
        dto.setId(id);
        return mapper.toDto(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
