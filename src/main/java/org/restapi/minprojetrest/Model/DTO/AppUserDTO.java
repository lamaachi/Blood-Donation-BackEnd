package org.restapi.minprojetrest.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String telephone;
    private Role role;

    public static AppUserDTO toDto(AppUser appUser) {
        return new AppUserDTO(
                appUser.getId(),
                appUser.getFirstname(),
                appUser.getLastname(),
                appUser.getUsername(),
                appUser.getTelephone(),
                appUser.getRole()
        );
    }

}
