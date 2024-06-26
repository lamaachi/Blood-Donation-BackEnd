package org.restapi.minprojetrest.Service.impl;

import org.restapi.minprojetrest.Model.AddRdvResponse;
import org.restapi.minprojetrest.Model.*;
import org.restapi.minprojetrest.Model.DTO.RendezVousDTO;
import org.restapi.minprojetrest.Repository.AppUserRepository;
import org.restapi.minprojetrest.Repository.CenterRepository;
import org.restapi.minprojetrest.Repository.CreneauRepository;
import org.restapi.minprojetrest.Repository.RendezVousRepository;
import org.restapi.minprojetrest.Service.RdvService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RdvServiceImpl implements RdvService {
    private final RendezVousRepository rendezVousRepository;
    private final AppUserRepository appUserRepository;
    private final CreneauRepository creneauRepository;
    private final CenterRepository centerRepository;

    public RdvServiceImpl(RendezVousRepository rendezVousRepository, AppUserRepository appUserRepository, CreneauRepository creneauRepository, CenterRepository centerRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.appUserRepository = appUserRepository;
        this.creneauRepository = creneauRepository;
        this.centerRepository = centerRepository;
    }

    @Override
//    @Transactional
    public AddRdvResponse addRdv(RdvRequest rdvRequest) {
        AppUser appUser = appUserRepository.findById(rdvRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("AppUser not found"));

        Creneau creneau = creneauRepository.findById(rdvRequest.getCreneauId())
                .orElseThrow(() -> new RuntimeException("Creneau not found"));

        Centre centre = centerRepository.findById(rdvRequest.getCentreId())
                .orElseThrow(() -> new RuntimeException("Centre not found"));

        int existingAppointments = rendezVousRepository.countByDateAndCreneauAndCentre(rdvRequest.getDate(), creneau, centre);

        if (existingAppointments >= centre.getMaxCapacity()) {
            return new AddRdvResponse(false, "Maximum number of appointments exceeded for the given time slot and date.");
        }

        RendezVous rendezVous = RendezVous.builder()
                .centre(centre)
                .creneau(creneau)
                .date(rdvRequest.getDate())
                .appUser(appUser)
                .status(true)
                .is_valid(false)
                .build();
        appUser.getRdvs().add(rendezVous);
        centre.getRdvs().add(rendezVous);
        rendezVousRepository.save(rendezVous);
        return  new AddRdvResponse(true, "Rdv added successfully.");
    }

    @Override
    public void removeRdv(RendezVous rendezVous) {
        rendezVousRepository.delete(rendezVous);
    }

    @Override
    public RendezVous updateRdv(RendezVous updatedRdv) {
        Optional<RendezVous> existingRdvOptional = rendezVousRepository.findById(updatedRdv.getId());
        if (existingRdvOptional.isPresent()) {
            RendezVous existingRdv = existingRdvOptional.get();
            existingRdv.setDate(updatedRdv.getDate());
            existingRdv.setCentre(updatedRdv.getCentre());
            existingRdv.setCreneau(updatedRdv.getCreneau());
            existingRdv.setAppUser(updatedRdv.getAppUser());
            return rendezVousRepository.save(existingRdv);
        } else {
            throw new RuntimeException("RendezVous not found");
        }
    }

    @Override
    public List<RendezVousDTO> getAll() {
        List<RendezVous> rendezVous = rendezVousRepository.findAll();

        return rendezVous.stream()
                .map(RendezVousDTO::RdvtoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RendezVousDTO> getByUserId(Long id) {
        Optional<AppUser> appUserOptional = appUserRepository.findById(id);

        if (appUserOptional.isPresent()) {
            AppUser appUser = appUserOptional.get();

            List<RendezVous> rendezVousList = rendezVousRepository.findByAppUser(appUser);

            return rendezVousList.stream()
                    .map(RendezVousDTO::RdvtoDto)
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("AppUser not found with id: " + id);
        }
    }

    @Override
    public void removeRdv(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public Optional<RendezVous> getById(Long id) {
        return rendezVousRepository.findById(id);
    }

    @Override
    public void desableRdv(Long id) {
        Optional<RendezVous> rdv = rendezVousRepository.findById(id);
        if(rdv.isPresent()){
            RendezVous updateRdv = rdv.get();
            updateRdv.setStatus(false);
            rendezVousRepository.save(updateRdv);
        }
    }

    @Override
    public void validateRdv(Long id) {
        Optional<RendezVous> rdv = rendezVousRepository.findById(id);
        if(rdv.isPresent()){
            RendezVous updateRdv = rdv.get();
            updateRdv.set_valid(true);
            rendezVousRepository.save(updateRdv);
        }
    }


}
