package org.restapi.minprojetrest.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.DTO.Info.CreneauInfo;
import org.restapi.minprojetrest.Model.DTO.Info.RdvInfo;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor@Builder
public class CentreDTO {
    private Long id;
    private String name;
    private String address;
    private String ville;
    private int reviews;
    private int maxCapacity;
    private String openingHours;
    private List<RdvInfo> rdvs;
    private List<CreneauInfo> creneaux;
    public static CentreDTO toDto(Centre centre) {
        return CentreDTO.builder()
                .id(centre.getId())
                .name(centre.getName())
                .address(centre.getAddress())
                .ville(centre.getVille())
                .reviews(centre.getReviews())
                .maxCapacity(centre.getMaxCapacity())
                .openingHours(centre.getOpeningHours())
                .rdvs(centre.getRdvs().stream().map(RdvInfo::fromRendezVous).collect(Collectors.toList()))
                .creneaux(centre.getCreneaux().stream().map(CreneauInfo::fromCreneau).collect(Collectors.toList()))
                .build();
    }
}
