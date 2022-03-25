package com.tornado.mawalltracker.repository;

import com.tornado.mawalltracker.data.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}