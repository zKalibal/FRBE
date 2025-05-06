
package it.finalround.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fr_users_favorites", uniqueConstraints = @UniqueConstraint(columnNames = {"iduser","idpost"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Favorite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="iduser")
    private Long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idpost")
    private Article post;
}
