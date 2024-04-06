package org.restapi.minprojetrest.Service;

import org.restapi.minprojetrest.Model.Centre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CenterService {
    List<Centre> getAllCentres();

    Optional<Centre> getCentreById(int id);

    Centre createCentre(Centre centre);

    Centre updateCentre(int id, Centre centreDetails);

    void deleteCentre(int id);
}
