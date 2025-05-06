package it.finalround.controller;

import it.finalround.dto.NotificationDto;
import it.finalround.mapper.NotificationMapper;
import it.finalround.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;
    private final NotificationMapper mapper;

    @GetMapping("/users/{userId}/notifications")
    public List<NotificationDto> list(@PathVariable Long userId) {
        return service.list(userId).stream().map(mapper::toDto).toList();
    }

    @PatchMapping("/notifications/{id}/seen")
    public void markSeen(@PathVariable Long id) {
        service.markSeen(id);
    }
}
