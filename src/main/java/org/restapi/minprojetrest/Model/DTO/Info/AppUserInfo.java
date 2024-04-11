package org.restapi.minprojetrest.Model.DTO.Info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserInfo {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String telephone;
    @JsonIgnore
    private String password;
    private Role role;
//    private List<RdvInfo> rdvs;

    public static AppUserInfo fromAppUser(AppUser appUser) {
        return AppUserInfo.builder()
                .id(appUser.getId())
                .firstname(appUser.getFirstname())
                .lastname(appUser.getLastname())
                .username(appUser.getUsername())
                .telephone(appUser.getTelephone())
                .password(appUser.getPassword()) // You might want to remove this line if you don't want to expose the password
                .role(appUser.getRole())
//                .rdvs(appUser.getRdvs().stream().map(RdvInfo::fromRendezVous).collect(Collectors.toList()))
                .build();
    }
}
