
package it.finalround.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="fr_rubrics")
@Data @NoArgsConstructor @AllArgsConstructor
public class Rubric{
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(length=5000) private String description;
}
