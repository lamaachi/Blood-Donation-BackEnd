package org.restapi.minprojetrest.Repository;

import org.restapi.minprojetrest.Model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Ref;
@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
    Region findByName(String name);
}
