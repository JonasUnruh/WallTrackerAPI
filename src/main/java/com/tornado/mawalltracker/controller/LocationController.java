package com.tornado.mawalltracker.controller;


import com.tornado.mawalltracker.data.Location;
import com.tornado.mawalltracker.data.LocationRepository;
import com.tornado.mawalltracker.data.RouteSetter;
import com.tornado.mawalltracker.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "location")
@CrossOrigin(origins = "*")
public class LocationController {

    private LocationRepository locationRepo;

    @Autowired
    public LocationController(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody final Location location) {
        this.locationRepo.save(location);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Location>> getAllLocations() {
        return new ResponseEntity<>(locationRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Integer> getLocationById(@PathVariable("id") final Long id) {
        Optional<Location> opLocation = locationRepo.findById(id);
        if (opLocation.isEmpty()) {
            return new ResponseEntity<>(-1, HttpStatus.NOT_FOUND);
        }
        Location location = opLocation.get();
        return new ResponseEntity(location, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}/delete")
    public ResponseEntity<Location> deleteLocation (@PathVariable("id") final  Long id) {
        locationRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
