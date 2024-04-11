package org.restapi.minprojetrest.Repository;

import org.restapi.minprojetrest.Model.Creneau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CreneauRepository extends JpaRepository<Creneau,Long> {

}
