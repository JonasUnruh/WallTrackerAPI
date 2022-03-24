package com.tornado.mawalltracker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoulderRepository extends CrudRepository<Boulder, Long> {
}
