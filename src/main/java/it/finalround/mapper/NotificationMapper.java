package it.finalround.mapper;

import it.finalround.dto.NotificationDto;
import it.finalround.entity.UserNotification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDto toDto(UserNotification n);
}
