package it.finalround.service;

import it.finalround.entity.Author;
import it.finalround.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repo;

    public List<Author> list() {return repo.findAll();}

    public Author get(Long id){return repo.findById(id).orElseThrow();}

    public Author save(Author a){return repo.save(a);}

    public void delete(Long id){repo.deleteById(id);}
}
