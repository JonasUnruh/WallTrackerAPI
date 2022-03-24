package com.tornado.mawalltracker.controller;


import com.tornado.mawalltracker.data.Location;
import com.tornado.mawalltracker.data.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
