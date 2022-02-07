package com.tornado.mawalltracker.controller;

import com.tornado.mawalltracker.data.Ratings;
import com.tornado.mawalltracker.data.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ratings")
@CrossOrigin(origins = "*")
public class RatingsController {

    private RatingsRepository ratingsRepo;

    @Autowired
    public RatingsController(RatingsRepository ratingsRepo){
        this.ratingsRepo = ratingsRepo;
    }

    @PostMapping
    public ResponseEntity<Ratings> createRatings(@RequestBody final Ratings rating){
        this.ratingsRepo.save(rating);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Ratings>> getAllRatings(){
        return new ResponseEntity<>(ratingsRepo.findAll(), HttpStatus.OK);
    }
}
