
package it.finalround.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="fr_platforms")
@Data @NoArgsConstructor @AllArgsConstructor
public class Platform{
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String slug;
  private Integer priority;
}
