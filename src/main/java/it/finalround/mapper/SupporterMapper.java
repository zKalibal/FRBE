package it.finalround.mapper;

import it.finalround.dto.SupporterDto;
import it.finalround.entity.PatreonSupporter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupporterMapper {
    SupporterDto toDto(PatreonSupporter s);
}
