package org.restapi.minprojetrest.Controller;

import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Repository.CenterRepository;
import org.restapi.minprojetrest.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/")
public class CenterController {

    @Autowired
    private CenterService centerService;
    // Get all centres
    @GetMapping(path = "/centre")
    public List<Centre> getAll(){
        return  centerService.getAllCentres();
    }
    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello user auth";
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
    public ResponseEntity<Centre> createCentre(@RequestBody Centre centre) {
        Centre newCentre = centerService.createCentre(centre);
        return ResponseEntity.ok(newCentre);
    }

    // Delete centre by ID
    @DeleteMapping("/centre/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> deleteCentre(@PathVariable int id) {
        centerService.deleteCentre(id);
        return ResponseEntity.ok().build();
    }
}
