package it.finalround.dto;

import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class NotificationDto {
    private Long id;
    private String message;
    private String link;
    private boolean seen;
}
