package com.tornato.WallTrackerRestAPI.service;

import com.tornato.WallTrackerRestAPI.entity.RouteSetter;
import com.tornato.WallTrackerRestAPI.repository.RouteSetterRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BoulderService {

    @Autowired
    private RouteSetterRepository routeSetterRepository;

    public Boolean testIfRoutSetterIsValid(Long routeSetterId){
        if(routeSetterRepository.existsById(routeSetterId)){
            return true;
        }
        else {
            return false;
        }
    }
}
