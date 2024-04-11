package org.restapi.minprojetrest.Service;

import org.restapi.minprojetrest.Model.*;
import org.restapi.minprojetrest.Model.DTO.RendezVousDTO;

import java.util.List;
import java.util.Optional;

public interface RdvService {
    RendezVous addRdv(RdvRequest rdvRequest);
    void removeRdv(RendezVous rendezVous);
    RendezVous updateRdv(RendezVous rendezVous);
    List<RendezVousDTO> getAll();
    List<RendezVousDTO> getByUserId(Long id);

    void removeRdv(Long id);
    Optional<RendezVous> getById(Long id);
}
