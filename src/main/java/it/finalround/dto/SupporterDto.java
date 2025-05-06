package it.finalround.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SupporterDto {
    private String id;
    private String fullName;
    private Integer lifetimeSupportCents;
    private String patronStatus;
    private String tier;
}
