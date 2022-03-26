package com.tornato.WallTrackerRestAPI.repository;

import com.tornato.WallTrackerRestAPI.entity.Boulder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoulderRepository extends JpaRepository<Boulder, Long> {

    public List<Boulder> findAllByRouteSetter_RouteSetterId(Long routeSetterId);

    public List<Boulder> findAllByLocation_LocationId(Long locationId);
}
