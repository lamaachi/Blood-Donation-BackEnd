package org.restapi.minprojetrest.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class AddRdvResponse {
    private boolean success;
    private String message;
}
