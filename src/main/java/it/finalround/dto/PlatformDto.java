
package it.finalround.dto;
import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor
public class PlatformDto{
  private Long id;
  private String name;
  private String slug;
  private Integer priority;
}
