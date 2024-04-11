package org.restapi.minprojetrest.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Getter
@Setter
public class CentreRequest {
    private Centre centre;
    private List<Creneau> creneaux;
}
