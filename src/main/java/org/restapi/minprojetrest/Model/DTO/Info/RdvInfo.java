package org.restapi.minprojetrest.Model.DTO.Info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restapi.minprojetrest.Model.RendezVous;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RdvInfo {

    private Long id;
    private LocalDate date;
    private CreneauInfo creneau;
    private AppUserInfo appUser;

    public static RdvInfo fromRendezVous(RendezVous rendezVous) {
        return RdvInfo.builder()
                .id(rendezVous.getId())
                .date(rendezVous.getDate())
                .creneau(CreneauInfo.fromCreneau(rendezVous.getCreneau()))
                .appUser(AppUserInfo.fromAppUser(rendezVous.getAppUser()))
                .build();
    }
}


