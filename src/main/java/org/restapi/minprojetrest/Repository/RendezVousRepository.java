package org.restapi.minprojetrest.Repository;

import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByAppUser(AppUser appUser);

    //    @Modifying
    //    @Query("DELETE FROM RendezVous r WHERE r.id = :id")
    //    void deleteByIdCustom(@Param("id") Long id);
}
