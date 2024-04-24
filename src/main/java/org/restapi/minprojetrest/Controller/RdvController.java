package org.restapi.minprojetrest.Controller;

import jakarta.transaction.Transactional;
import org.restapi.minprojetrest.Model.AddRdvResponse;
import org.restapi.minprojetrest.Model.DTO.RendezVousDTO;
import org.restapi.minprojetrest.Model.RdvRequest;
import org.restapi.minprojetrest.Service.impl.RdvServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class RdvController {

    private final RdvServiceImpl rdvService;

    public RdvController(RdvServiceImpl rdvService) {
        this.rdvService = rdvService;
    }
    // Get all Rdvs
    @GetMapping(path = "/rdv")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
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
    public ResponseEntity<AddRdvResponse> createRdv(@RequestBody RdvRequest rdvRequest) {
        AddRdvResponse response = rdvService.addRdv(rdvRequest);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/rdv/{id}")
    public void disableRdv(@PathVariable Long id){
        rdvService.desableRdv(id);
    }

    @PutMapping("/rdv/validate/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> validateRdv(@PathVariable Long id){
        rdvService.validateRdv(id);
        return ResponseEntity.ok("Rdv  Validated...");
    }

}
