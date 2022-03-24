package com.tornado.mawalltracker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteSetterRepository extends CrudRepository<RouteSetter, Long> {
}
