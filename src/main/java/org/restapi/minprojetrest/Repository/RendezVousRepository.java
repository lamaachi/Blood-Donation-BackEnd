package org.restapi.minprojetrest.Repository;

import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByCentre(Centre centre);

    List<RendezVous> findByAppUser(AppUser appUser);
}
