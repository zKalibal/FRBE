
package it.finalround.mapper;
import it.finalround.dto.RubricDto;
import it.finalround.entity.Rubric;
import org.mapstruct.Mapper;
@Mapper(componentModel="spring")
public interface RubricMapper{
  RubricDto toDto(Rubric r);
}
