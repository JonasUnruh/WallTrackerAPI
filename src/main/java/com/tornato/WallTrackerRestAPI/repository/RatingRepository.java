package com.tornato.WallTrackerRestAPI.repository;

import com.tornato.WallTrackerRestAPI.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    public List<Rating> findAllByBoulder_BoulderId(Long boulderId);

    public List<Rating> findAllByUser_UserId(Long userId);

}
