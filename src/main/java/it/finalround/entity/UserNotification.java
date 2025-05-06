package it.finalround.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fr_users_notifications")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserNotification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iduser", nullable = false)
    private Long userId;

    private String message;
    private String link;

    @Column(name = "seen", columnDefinition = "tinyint(1) default 0")
    private boolean seen;
}
