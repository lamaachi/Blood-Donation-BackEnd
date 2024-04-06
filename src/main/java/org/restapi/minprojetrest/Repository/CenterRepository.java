package org.restapi.minprojetrest.Repository;

import org.restapi.minprojetrest.Model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Centre,Integer> {
}
