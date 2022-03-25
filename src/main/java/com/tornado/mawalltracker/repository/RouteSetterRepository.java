package com.tornado.mawalltracker.repository;

import com.tornado.mawalltracker.data.RouteSetter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteSetterRepository extends CrudRepository<RouteSetter, Long> {
}
