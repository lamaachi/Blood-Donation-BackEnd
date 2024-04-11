package org.restapi.minprojetrest.Repository;

import org.restapi.minprojetrest.Model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<RendezVous,Long> {
}
