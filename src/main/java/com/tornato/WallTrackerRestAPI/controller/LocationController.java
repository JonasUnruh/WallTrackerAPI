package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.Location;
import com.tornato.WallTrackerRestAPI.repository.LocationRepository;
import com.tornato.WallTrackerRestAPI.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.OptionalDouble;

@RestController
@RequestMapping("location")
@AllArgsConstructor
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    public RatingService ratingService;

    @PostMapping
    private void createLocation(@RequestBody Location location){
        locationRepository.save(location);
        return;
    }

    @GetMapping
    private Iterable<Location> findAllLocations(){
        return locationRepository.findAll();
    }

    @GetMapping("/id/{id}")
    private Optional<Location> findLocationById(@PathVariable Long id){
        return locationRepository.findById(id);
    }

    @GetMapping("/id/{id}/ratingsmean")
    private OptionalDouble findBoulderRatingsMeanById(@PathVariable Long id){
        return ratingService.calcRatingsMeanByLocationId(id);
    }
}
