package org.restapi.minprojetrest.Model.DTO.Info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreneauInfo {
    private Long id;
    private String heureDebut;
    private String heureFin;

    public static CreneauInfo fromCreneau(org.restapi.minprojetrest.Model.Creneau creneau) {
        return CreneauInfo.builder()
                .id(creneau.getId())
                .heureDebut(creneau.getHeureDebut())
                .heureFin(creneau.getHeureFin())
                .build();
    }
}
