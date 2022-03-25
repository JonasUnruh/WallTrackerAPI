package com.tornado.mawalltracker.repository;

import com.tornado.mawalltracker.data.Ratings;
import com.tornado.mawalltracker.data.RatingsId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends CrudRepository<Ratings, RatingsId> {

    /*
    List<Ratings> findByUserId(Long userId);

    List<Ratings> findByBoulderId(Long boulderId);

    List<Ratings> findByLocationId(Long locationId);*/
}
