package org.restapi.minprojetrest.Controller;

import jakarta.transaction.Transactional;
import org.restapi.minprojetrest.Model.DTO.RendezVousDTO;
import org.restapi.minprojetrest.Model.RdvRequest;
import org.restapi.minprojetrest.Model.RendezVous;
import org.restapi.minprojetrest.Service.impl.RdvServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @Transactional
    public ResponseEntity<String> deleteRdv(@PathVariable Long id) {
        rdvService.removeRdv(id);
        return ResponseEntity.ok("Rdv Deleted");
    }

    // Create a new Rdv
    @PostMapping(path = "/rdv")
    public ResponseEntity<RendezVous> createRdv(@RequestBody RdvRequest rdvRequest) {
        RendezVous rdv = rdvService.addRdv(rdvRequest);
        return ResponseEntity.ok(rdv);
    }
}
