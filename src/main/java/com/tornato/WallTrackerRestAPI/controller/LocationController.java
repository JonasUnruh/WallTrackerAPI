package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.Location;
import com.tornato.WallTrackerRestAPI.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("location")
@AllArgsConstructor
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping
    private void createLocation(@RequestBody Location location){
        locationRepository.save(location);
        return;
    }

    @GetMapping
    private Iterable<Location> findeAllLocations(){
        return locationRepository.findAll();
    }

    @GetMapping("/id/{id}")
    private Optional<Location> findeLocationById(@PathVariable Long id){
        return locationRepository.findById(id);
    }
}
