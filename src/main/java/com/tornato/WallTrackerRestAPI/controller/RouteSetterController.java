package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.RouteSetter;
import com.tornato.WallTrackerRestAPI.repository.RouteSetterRepository;
import com.tornato.WallTrackerRestAPI.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("routesetter")
@CrossOrigin("*")
public class RouteSetterController {

    @Autowired
    private RouteSetterRepository routeSetterRepository;

    @Autowired
    private RatingService ratingService;

    public RouteSetterController(RouteSetterRepository routeSetterRepository) {
        this.routeSetterRepository = routeSetterRepository;
    }

    @PostMapping
    public void createRouteSetter(@RequestBody RouteSetter routeSetter){
        routeSetterRepository.save(routeSetter);
        return;
    }

    @GetMapping("/id/{id}/ratingsmean")
    private OptionalDouble findRouteSetterRatingsMeanById(@PathVariable Long id){
        return ratingService.calcRatingsMeanByRouteSetterId(id);
    }
}
