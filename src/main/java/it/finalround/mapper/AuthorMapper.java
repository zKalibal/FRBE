package it.finalround.mapper;

import it.finalround.dto.AuthorDto;
import it.finalround.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author a);
    Author toEntity(AuthorDto dto);
}
