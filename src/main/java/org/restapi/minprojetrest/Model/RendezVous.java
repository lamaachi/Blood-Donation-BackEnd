package org.restapi.minprojetrest.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Centre centre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Creneau creneau;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUser;

    private boolean is_valid;

    private Boolean status;

}
