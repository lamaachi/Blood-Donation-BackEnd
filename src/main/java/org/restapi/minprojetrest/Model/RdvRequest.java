package org.restapi.minprojetrest.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class RdvRequest {
    private Long userId; // ID of the AppUser
    private Long creneauId; // ID of the Creneau
    private Long centreId; // ID of the Centre
    private LocalDate date;
}
