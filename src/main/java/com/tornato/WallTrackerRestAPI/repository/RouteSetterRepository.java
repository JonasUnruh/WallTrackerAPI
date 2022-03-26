package com.tornato.WallTrackerRestAPI.repository;

import com.tornato.WallTrackerRestAPI.entity.RouteSetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteSetterRepository extends JpaRepository<RouteSetter, Long>{
}
