
package it.finalround.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "fr_posts_comments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpost")
    private Article post;

    private Long userId;       // user system not implemented yet

    @Column(length = 8000, nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply")
    private Comment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> replies;

    private Long pinnedBy;

    private Instant date = Instant.now();

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<CommentLike> likes;
}
