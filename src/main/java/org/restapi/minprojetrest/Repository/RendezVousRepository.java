package org.restapi.minprojetrest.Repository;

import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.Creneau;
import org.restapi.minprojetrest.Model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByAppUser(AppUser appUser);
    List<RendezVous> findAllByStatus(Boolean status);
    int countByDateAndCreneauAndCentre(LocalDate date, Creneau creneau,Centre centre);
}
