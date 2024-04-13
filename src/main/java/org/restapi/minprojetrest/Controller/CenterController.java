package org.restapi.minprojetrest.Controller;

import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.CentreRequest;
import org.restapi.minprojetrest.Model.Creneau;
import org.restapi.minprojetrest.Model.DTO.CentreDTO;
import org.restapi.minprojetrest.Repository.CenterRepository;
import org.restapi.minprojetrest.Service.CenterService;
import org.restapi.minprojetrest.Service.impl.CreneauServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/")
public class CenterController {


    private CenterService centerService;
    private CreneauServiceimpl creneauServiceimpl;

    public CenterController(CenterService centerService, CreneauServiceimpl creneauServiceimpl) {
        this.centerService = centerService;
        this.creneauServiceimpl = creneauServiceimpl;
    }

    // Get all centres
    @GetMapping(path = "/centre")
    public List<CentreDTO> getAll(){
        return  centerService.getAllCentres();
    }

    // Get centre by ID
    @GetMapping("/centre/{id}")
    public ResponseEntity<Centre> getCentreById(@PathVariable int id) {
        Centre centre = centerService.getCentreById(id)
                .orElseThrow(() -> new RuntimeException("Centre not found with id: " + id));
        return ResponseEntity.ok(centre);
    }

    // Create a new centre
    @PostMapping(path = "/centre")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Centre> createCentre(@RequestBody CentreRequest centreRequest) {
        Centre newCentre = centerService.createCentre(centreRequest.getCentre());
        System.out.println("+=====================centreRequest.getCreneaux()================");
        System.out.println(centreRequest.getCreneaux());
        List<Creneau> creneaux = centreRequest.getCreneaux();
        if (newCentre.getCreneaux() == null) {
            newCentre.setCreneaux(new ArrayList<>());
        }

        for (Creneau creneau : creneaux) {
            creneau.setCentre(newCentre);
            creneauServiceimpl.createCreneau(newCentre.getId(), creneau);
        }
        System.out.println("+=====================newCentre.getCreneaux()================");
        System.out.println(newCentre.getCreneaux());
        return ResponseEntity.ok(newCentre);
    }

    // Delete centre by ID
    @DeleteMapping("/centre/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> deleteCentre(@PathVariable int id) {
        centerService.deleteCentre(id);
        return ResponseEntity.ok().build();
    }

    // Update centre by ID
    @PutMapping("/centre/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Centre> updateCentre(@PathVariable int id, @RequestBody CentreRequest centreRequest) {
        Centre updatedCentre = centerService.updateCentre(id, centreRequest);
        return ResponseEntity.ok(updatedCentre);
    }
}
