package org.restapi.minprojetrest.Controller;

import org.restapi.minprojetrest.Model.DTO.RendezVousDTO;
import org.restapi.minprojetrest.Model.RdvRequest;
import org.restapi.minprojetrest.Model.RendezVous;
import org.restapi.minprojetrest.Repository.RdvRepository;
import org.restapi.minprojetrest.Service.RdvService;
import org.restapi.minprojetrest.Service.impl.RdvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/")
public class RdvController {

    private final RdvServiceImpl rdvService;

    public RdvController(RdvServiceImpl rdvService) {
        this.rdvService = rdvService;
    }
    // Get all Rdvs
    @GetMapping(path = "/rdv")
    public ResponseEntity<List<RendezVousDTO>> getAllRdvs() {
        List<RendezVousDTO> rdvs = rdvService.getAll();
        return ResponseEntity.ok(rdvs);
    }
    // Get RendezVous by User ID
    @GetMapping("/rdv/user/{id}")
    public ResponseEntity<List<RendezVousDTO>> getByUserId(@PathVariable Long id) {
        List<RendezVousDTO> rdvs = rdvService.getByUserId(id);
        return ResponseEntity.ok(rdvs);
    }

    // Delete Rdv by ID
    @DeleteMapping("/rdv/{id}")
    public ResponseEntity<Void> deleteRdv(@PathVariable Long id) {
        Optional<RendezVous> rendezVous = rdvService.getById(id);
        if (rendezVous.get() != null) {
            rdvService.removeRdv(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update Rdv
//    @PutMapping("/rdv")
//    public ResponseEntity<RendezVous> updateRdv(@RequestBody RendezVous updatedRdv) {
//        RendezVous rdv = rdvService.updateRdv(updatedRdv);
//        return ResponseEntity.ok(rdv);
//    }


    // Create a new Rdv
    @PostMapping(path = "/rdv")
    public ResponseEntity<RendezVous> createRdv(@RequestBody RdvRequest rdvRequest) {
        RendezVous rdv = rdvService.addRdv(rdvRequest);
        return ResponseEntity.ok(rdv);
    }
}
