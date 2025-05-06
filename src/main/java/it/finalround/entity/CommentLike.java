
package it.finalround.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fr_posts_comments_likes",
       uniqueConstraints = @UniqueConstraint(columnNames = {"idcomment","iduser"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CommentLike {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcomment", nullable = false)
    private Comment comment;

    private Long userId;

    /**
     * 1 = like, 0 = dislike
     */
    private Integer type;
}
