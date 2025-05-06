package it.finalround.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fr_authors")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String description;
    private String email;

    @Column(name = "socials")
    private String socialsJson; // JSON string con URL social
}
