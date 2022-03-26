package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.Boulder;
import com.tornato.WallTrackerRestAPI.repository.BoulderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("boulder")
public class BoulderController {

    @Autowired
    private BoulderRepository boulderRepository;

    public BoulderController(BoulderRepository boulderRepository) {
        this.boulderRepository = boulderRepository;
    }

    @PostMapping("")
    public void createBoulder(@RequestBody Boulder boulder){
        boulderRepository.save(boulder);
        return;
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
}
