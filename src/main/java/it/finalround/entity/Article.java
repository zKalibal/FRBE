
package it.finalround.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;
import it.finalround.enums.ArticleType;
import it.finalround.data.converter.ArticleTypeConverter;
@Entity @Table(name="fr_posts")
@Data @NoArgsConstructor @AllArgsConstructor
public class Article{
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String title;
  @Column(name="short_description", length=1000)
  private String shortDescription;
  @Column(name="meta_title") private String metaTitle;
  @Column(name="meta_description", length=1000) private String metaDescription;

  @Convert(converter=ArticleTypeConverter.class)
  private ArticleType type;

  /** denormalised platforms list kept in join table */
  @ManyToMany
  @JoinTable(name="articles_platforms",
              joinColumns=@JoinColumn(name="article_id"),
              inverseJoinColumns=@JoinColumn(name="platform_id"))
  private Set<Platform> platforms;

  @ManyToOne @JoinColumn(name="ref_platform")
  private Platform refPlatform;

  @ManyToOne @JoinColumn(name="rubric")
  private Rubric rubric;

  private boolean featured;
  @Lob
  private String content;
  private int status;
  private String subscriptions;

  @ManyToOne @JoinColumn(name="author_id")
  private Author author;

  private LocalDateTime date;
}
