package it.finalround.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class AuthorDto {
    private Long id;
    private String fullname;
    private String description;
    private String email;
}
