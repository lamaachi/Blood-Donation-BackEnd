package org.restapi.minprojetrest.Service.impl;

import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.CentreRequest;
import org.restapi.minprojetrest.Model.Creneau;
import org.restapi.minprojetrest.Model.DTO.CentreDTO;
import org.restapi.minprojetrest.Model.Ville;
import org.restapi.minprojetrest.Repository.CenterRepository;
import org.restapi.minprojetrest.Repository.VilleRepository;
import org.restapi.minprojetrest.Service.CenterService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CenterServiceImpl implements CenterService {

    CenterRepository centerRepository;
    VilleRepository villeRepository;
    public CenterServiceImpl(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    @Override
    public List<CentreDTO> getAllCentres() {
        return centerRepository.findAll().stream()
                .map(CentreDTO::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Centre> getCentreById(int id) {
        return centerRepository.findById(Long.parseLong(String.valueOf(id)));
    }

    @Override
    public Centre createCentre(Centre centre) {
        centerRepository.save(centre);
        return centre;
    }

    @Override
    public Centre updateCentre(int id, CentreRequest centreRequest) {
        Optional<Centre> centreOpt = centerRepository.findById(Long.parseLong(String.valueOf(id)));
        if(centreOpt.isPresent()){
            Centre updatedCentre = centreOpt.get();
            System.out.print(updatedCentre);


            // Update Centre details
            updatedCentre.setName(centreRequest.getCentre().getName());
            updatedCentre.setAddress(centreRequest.getCentre().getAddress());
            updatedCentre.setVille(centreRequest.getCentre().getVille());
            updatedCentre.setMaxCapacity(centreRequest.getCentre().getMaxCapacity());
            updatedCentre.setOpeningHours(centreRequest.getCentre().getOpeningHours());

            // Update Creneaux
            List<Creneau> existingCreneaux = updatedCentre.getCreneaux();
            List<Creneau> newCreneaux = centreRequest.getCreneaux();

            // Remove existing creneaux not present in the new list
            existingCreneaux.removeIf(existingCreneau ->
                    newCreneaux.stream().noneMatch(newCreneau -> newCreneau.getId().equals(existingCreneau.getId()))
            );

            // Update or add new creneaux
            for (Creneau newCreneau : newCreneaux) {
                newCreneau.setCentre(updatedCentre);
                if (newCreneau.getId() != null) {
                    // Update existing creneau
                    Creneau existingCreneau = existingCreneaux.stream()
                            .filter(creneau -> creneau.getId().equals(newCreneau.getId()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Creneau not found with id: " + newCreneau.getId()));

                    existingCreneau.setHeureDebut(newCreneau.getHeureDebut());
                    existingCreneau.setHeureFin(newCreneau.getHeureFin());
                } else {
                    // Add new creneau
                    existingCreneaux.add(newCreneau);
                }
            }

            return centerRepository.save(updatedCentre);
        } else {
            throw new RuntimeException("Centre not found with id: " + id);
        }
    }


    @Override
    public void deleteCentre(int id) {
        Optional<Centre> centre = centerRepository.findById(Long.parseLong(String.valueOf(id)));
        if (centre.isPresent()) {
            centerRepository.delete(centre.get());
        } else {
            throw new RuntimeException("Centre not found with id: " + id);
        }
    }
}
