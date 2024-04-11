package org.restapi.minprojetrest.Service.impl;


import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.Creneau;
import org.restapi.minprojetrest.Repository.CenterRepository;
import org.restapi.minprojetrest.Repository.CreneauRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreneauServiceimpl {
    private final CenterRepository centerRepository;
    private final CreneauRepository creneauRepository;

    public CreneauServiceimpl(CenterRepository centerRepository, CreneauRepository creneauRepository) {
        this.centerRepository = centerRepository;
        this.creneauRepository = creneauRepository;
    }

    public Creneau createCreneau(Long centreId, Creneau creneau) {
        Optional<Centre> optionalCentre = centerRepository.findById(centreId);
        if (optionalCentre.isPresent()) {
            Centre centre = optionalCentre.get();
            creneau.setCentre(centre);
            centre.getCreneaux().add(creneau);
            centerRepository.save(centre);
            creneauRepository.save(creneau);
            return creneau;
        } else {
            throw new RuntimeException("Centre not found with id: " + centreId);
        }
    }

    public Creneau updateCreneau(Long centreId, Long creneauId, Creneau creneauRequest) {
        Optional<Centre> optionalCentre = centerRepository.findById(centreId);
        if (optionalCentre.isPresent()) {
            Centre centre = optionalCentre.get();
            Optional<Creneau> optionalCreneau = centre.getCreneaux().stream()
                    .filter(creneau -> creneau.getId().equals(creneauId))
                    .findFirst();

            if (optionalCreneau.isPresent()) {
                Creneau existingCreneau = optionalCreneau.get();
                existingCreneau.setHeureDebut(creneauRequest.getHeureDebut());
                existingCreneau.setHeureFin(creneauRequest.getHeureFin());

                creneauRepository.save(existingCreneau);
                return existingCreneau;
            } else {
                throw new RuntimeException("Creneau not found with id: " + creneauId);
            }
        } else {
            throw new RuntimeException("Centre not found with id: " + centreId);
        }
    }

}
