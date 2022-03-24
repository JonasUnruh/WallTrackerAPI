package com.tornado.mawalltracker.controller;

import com.tornado.mawalltracker.data.Boulder;
import com.tornado.mawalltracker.data.BoulderRepository;
import com.tornado.mawalltracker.data.RouteSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "boulder")
@CrossOrigin(origins = "*")
public class BoulderController {

    private BoulderRepository boulderRepo;

    @Autowired
    public BoulderController(BoulderRepository boulderRepo) {
        this.boulderRepo = boulderRepo;
    }

    @PostMapping
    public ResponseEntity<Boulder> createBoulder(@RequestBody final Boulder boulder) {
        this.boulderRepo.save(boulder);
        return new ResponseEntity<>(boulder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Boulder>> getALlBoulders(){
        return new ResponseEntity<>(boulderRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Integer> getBoulderById(@PathVariable("id") final Long id) {
        Optional<Boulder> opBoulder = boulderRepo.findById(id);
        if (opBoulder.isEmpty()) {
            return new ResponseEntity<>(-1, HttpStatus.NOT_FOUND);
        }
        Boulder boulder = opBoulder.get();
        return new ResponseEntity(boulder, HttpStatus.OK);
    }
}
