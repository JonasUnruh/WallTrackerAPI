package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.Rating;
import com.tornato.WallTrackerRestAPI.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rating")
@AllArgsConstructor
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping
    private void createRating(@RequestBody Rating rating){
        ratingRepository.save(rating);
        return;
    }

    @GetMapping("/id/{id}")
    public Optional<Rating> getRatingById(@PathVariable Long id){
        return ratingRepository.findById(id);
    }

    // Todo mach das nur die Ids zurück gegeben werden!
    @GetMapping("/boulder/{id}")
    public Iterable<Rating> findAllRatingsByBoulder(@PathVariable Long id){
        return ratingRepository.findAllByBoulder_BoulderId(id);
    }

    // Todo mach das nur die Ids zurück gegeben werden!
    @GetMapping("/user/{id}")
    public Iterable<Rating> findAllRatingsByUser(@PathVariable Long id){
        return ratingRepository.findAllByUser_UserId(id);
    }
}
