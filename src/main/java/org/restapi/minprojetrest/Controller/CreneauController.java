package org.restapi.minprojetrest.Controller;

import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.Creneau;
import org.restapi.minprojetrest.Repository.CreneauRepository;
import org.restapi.minprojetrest.Service.impl.CreneauServiceimpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/")
public class CreneauController {

    private CreneauRepository creneauRepository;

    public CreneauController(CreneauRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }

    @PostMapping(path = "/creneau")
    public ResponseEntity<Creneau> createCreneau(@RequestBody Creneau creneau) {
        Creneau newCreneau = creneauRepository.save(creneau);
        return ResponseEntity.ok(newCreneau);
    }
}
