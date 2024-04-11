package org.restapi.minprojetrest.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restapi.minprojetrest.Model.RendezVous;
import org.restapi.minprojetrest.Model.DTO.Info.CentreInfo;
import org.restapi.minprojetrest.Model.DTO.Info.CreneauInfo;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVousDTO {
    private Long id;
    private LocalDateTime date;
    private CentreInfo centre;
    private CreneauInfo creneau;
    public static RendezVousDTO RdvtoDto(RendezVous rendezVous){
        return RendezVousDTO.builder()
                .id(rendezVous.getId())
                .date(rendezVous.getDate())
                .centre(new CentreInfo(
                        rendezVous.getCentre().getId(),
                        rendezVous.getCentre().getName(),
                        rendezVous.getCentre().getAddress()
                ))
                .creneau(new CreneauInfo(
                        rendezVous.getCreneau().getId(),
                        rendezVous.getCreneau().getHeureDebut(),
                        rendezVous.getCreneau().getHeureFin()
                ))

                .build();
    }
}
