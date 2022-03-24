package com.tornado.mawalltracker.controller;

import com.tornado.mawalltracker.data.RouteSetter;
import com.tornado.mawalltracker.data.RouteSetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "route_setter")
@CrossOrigin(origins = "*")
public class RouteSetterController {

    private RouteSetterRepository routeSetterRepo;

    @Autowired
    public RouteSetterController(RouteSetterRepository routeSetterRepo) {
        this.routeSetterRepo = routeSetterRepo;
    }

    @PostMapping
    public ResponseEntity<RouteSetter> createRouteSetter(@RequestBody final RouteSetter routeSetter) {
        this.routeSetterRepo.save(routeSetter);
        return new ResponseEntity<>(routeSetter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<RouteSetter>> getAllRouteSetter() {
        return new ResponseEntity<>(routeSetterRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Integer> getRouteSetterById(@PathVariable("id") final Long id) {
        Optional<RouteSetter> opRouteSetter = routeSetterRepo.findById(id);
        if (opRouteSetter.isEmpty()) {
            return new ResponseEntity<>(-1, HttpStatus.NOT_FOUND);
        }
        RouteSetter routeSetter = opRouteSetter.get();
        return new ResponseEntity(routeSetter, HttpStatus.OK);
    }
}
