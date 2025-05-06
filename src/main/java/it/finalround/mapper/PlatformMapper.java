
package it.finalround.mapper;
import it.finalround.dto.PlatformDto;
import it.finalround.entity.Platform;
import org.mapstruct.Mapper;
@Mapper(componentModel="spring")
public interface PlatformMapper{
  PlatformDto toDto(Platform p);
}
