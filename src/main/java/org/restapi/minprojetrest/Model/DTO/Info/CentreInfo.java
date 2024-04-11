package org.restapi.minprojetrest.Model.DTO.Info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentreInfo {
    private Long id;
    private String name;
    private String address;
}
