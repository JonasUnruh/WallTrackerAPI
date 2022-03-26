package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.RouteSetter;
import com.tornato.WallTrackerRestAPI.repository.RouteSetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("routesetter")
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
