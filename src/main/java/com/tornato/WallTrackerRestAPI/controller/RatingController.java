package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.Rating;
import com.tornato.WallTrackerRestAPI.repository.BoulderRepository;
import com.tornato.WallTrackerRestAPI.repository.RatingRepository;
import com.tornato.WallTrackerRestAPI.repository.UserRepository;
import com.tornato.WallTrackerRestAPI.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rating")
@AllArgsConstructor
@CrossOrigin("*")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoulderRepository boulderRepository;



    @PostMapping
    private ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        if(userRepository.existsById(rating.getUser().getUserId()) && boulderRepository.existsById(rating.getBoulder().getBoulderId())){
            ratingRepository.save(rating);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        }
        return new ResponseEntity(-1, HttpStatus.FAILED_DEPENDENCY);
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
