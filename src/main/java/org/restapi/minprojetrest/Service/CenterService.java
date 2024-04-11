package org.restapi.minprojetrest.Service;

import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.CentreRequest;
import org.restapi.minprojetrest.Model.DTO.CentreDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CenterService {
    List<CentreDTO> getAllCentres();

    Optional<Centre> getCentreById(int id);

    Centre createCentre(Centre centre);

    Centre updateCentre(int id, CentreRequest centreRequest);

    void deleteCentre(int id);
}
