package com.tornado.mawalltracker.controller;


import com.tornado.mawalltracker.data.Progress;
import com.tornado.mawalltracker.data.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "progress")
@CrossOrigin(origins = "*")
public class ProgressController {

    private ProgressRepository progressRepo;

    @Autowired
    public ProgressController(ProgressRepository progressRepo) {this.progressRepo = progressRepo; }

    @PostMapping
    public ResponseEntity<Progress> createProgress(@RequestBody final Progress progress){
        this.progressRepo.save(progress);
        return new ResponseEntity<>(progress, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Progress>> getProgress(){
        return new ResponseEntity<>(progressRepo.findAll(), HttpStatus.OK);
    }

}
