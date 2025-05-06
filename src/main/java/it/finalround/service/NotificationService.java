package it.finalround.service;

import it.finalround.entity.UserNotification;
import it.finalround.repository.UserNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final UserNotificationRepository repo;

    public void create(Long userId, String message, String link) {
        repo.save(UserNotification.builder()
                .userId(userId)
                .message(message)
                .link(link)
                .seen(false)
                .build());
    }

    public List<UserNotification> list(Long userId) {
        return repo.findByUserIdOrderByIdDesc(userId);
    }

    @Transactional
    public void markSeen(Long id) {
        repo.findById(id).ifPresent(n -> {
            n.setSeen(true);
            // grazie a @Transactional la modifica viene flushata
        });
    }
}
