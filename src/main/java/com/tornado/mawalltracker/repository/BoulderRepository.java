package com.tornado.mawalltracker.repository;

import com.tornado.mawalltracker.data.Boulder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoulderRepository extends CrudRepository<Boulder, Long> {
}
