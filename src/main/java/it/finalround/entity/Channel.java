package it.finalround.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fr_channels")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Channel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // PK interno

    private String name;        // “RoundTwo”
    @Column(name = "channel_id")
    private Long channelId;     // numeric Twitch broadcaster_id
}
