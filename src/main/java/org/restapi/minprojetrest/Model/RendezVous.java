package org.restapi.minprojetrest.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Centre centre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Creneau creneau;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUser;

}
