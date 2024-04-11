package org.restapi.minprojetrest.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String message ;
   //private AppUser appUser;

}
