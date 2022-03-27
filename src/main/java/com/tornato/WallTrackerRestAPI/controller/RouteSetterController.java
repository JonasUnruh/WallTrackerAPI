package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.RouteSetter;
import com.tornato.WallTrackerRestAPI.repository.RouteSetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("routesetter")
@CrossOrigin("*")
public class RouteSetterController {

    @Autowired
    private RouteSetterRepository routeSetterRepository;

    public RouteSetterController(RouteSetterRepository routeSetterRepository) {
        this.routeSetterRepository = routeSetterRepository;
    }

    @PostMapping
    public void createRouteSetter(@RequestBody RouteSetter routeSetter){
        routeSetterRepository.save(routeSetter);
        return;
    }
}
