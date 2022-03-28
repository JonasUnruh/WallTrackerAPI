package com.tornato.WallTrackerRestAPI.service;

import com.tornato.WallTrackerRestAPI.entity.Rating;
import com.tornato.WallTrackerRestAPI.repository.RatingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    public OptionalDouble calcRatingsMeanByBoulderId(Long boulderId){
         return ratingRepository.findAllByBoulder_BoulderId(boulderId)
                 .stream().map(Rating::getRating).collect(Collectors.toList())
                 .stream().mapToDouble(d -> d).average();

    }

    public OptionalDouble calcRatingsMeanByLocationId(Long locationId){
        return ratingRepository.findAllByBoulder_Location_LocationId(locationId)
                .stream().map(Rating::getRating).collect(Collectors.toList())
                .stream().mapToDouble(d -> d).average();
    }

    public OptionalDouble calcRatingsMeanByRouteSetterId(Long routeSetterId){
        return ratingRepository.findAllByBoulder_RouteSetter_RouteSetterId(routeSetterId)
                .stream().map(Rating::getRating).collect(Collectors.toList())
                .stream().mapToDouble(d -> d).average();
    }
}
