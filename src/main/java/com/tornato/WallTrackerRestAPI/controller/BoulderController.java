package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.Boulder;
import com.tornato.WallTrackerRestAPI.repository.BoulderRepository;
import com.tornato.WallTrackerRestAPI.repository.LocationRepository;
import com.tornato.WallTrackerRestAPI.repository.RouteSetterRepository;
import com.tornato.WallTrackerRestAPI.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.OptionalDouble;

@RestController
@RequestMapping("boulder")
@AllArgsConstructor
@CrossOrigin("*")
public class BoulderController {

    @Autowired
    private BoulderRepository boulderRepository;

    @Autowired
    private RouteSetterRepository routeSetterRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RatingService ratingService;


    @PostMapping("")
    public ResponseEntity<Boulder> createBoulder(@RequestBody Boulder boulder){
        if(routeSetterRepository.existsById(boulder.getRouteSetter().getRouteSetterId()) && locationRepository.existsById(boulder.getLocation().getLocationId())){
            boulderRepository.save(boulder);
            return new ResponseEntity<>(boulder, HttpStatus.OK);
        }
        return new ResponseEntity(-1, HttpStatus.FAILED_DEPENDENCY);

    }

    @GetMapping("/id/{id}")
    public Optional<Boulder> getBoulderById(@PathVariable Long id){
        return boulderRepository.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteBoulderById(@PathVariable Long id){
        boulderRepository.deleteById(id);
        return;
    }

    @PutMapping("/id/{id}")
    public void updateBoulderById(@PathVariable Long id, @RequestBody Boulder boulder){
        boulder.setBoulderId(id);
        boulderRepository.save(boulder);
        return;
    }

    // Todo mach das nur die Ids zurück gegeben werden!
    @GetMapping("/routesetter/{id}")
    public Iterable<Boulder> findBoulderByRouteSetter(@PathVariable Long id){
        return boulderRepository.findAllByRouteSetter_RouteSetterId(id);
    }

    @GetMapping("/location/{id}")
    public Iterable<Boulder> findBoulderByLocation(@PathVariable Long id){
        return boulderRepository.findAllByLocation_LocationId(id);
    }

    @GetMapping("/id/{id}/ratingsmean")
    private OptionalDouble findBoulderRatingsMeanById(@PathVariable Long id){
        return ratingService.calcRatingsMeanByBoulderId(id);
    }
}
