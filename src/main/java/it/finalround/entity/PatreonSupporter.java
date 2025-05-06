package it.finalround.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fr_patreon_supporters")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class PatreonSupporter {

    @Id
    private String id;            // Patreon ID (varchar PK)

    private String email;
    private String fullName;

    private Integer lifetimeSupportCents;
    private Integer campaignLifetimeSupportCents;

    private String patronStatus;      // active_patron, declined_patron, former_patron
    private Integer pledgeCadence;    // mesi

    private String tier;
    private Integer tierId;
}
