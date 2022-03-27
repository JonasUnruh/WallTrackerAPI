package com.tornato.WallTrackerRestAPI.controller;

import com.tornato.WallTrackerRestAPI.entity.User;
import com.tornato.WallTrackerRestAPI.repository.UserRepository;
import com.tornato.WallTrackerRestAPI.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public RatingService ratingService;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userRepository.save(user);
        return;
    }

    @GetMapping
    public List<User> indexUser(){
        return userRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<User> findUserById(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @GetMapping("/email/{emailId}")
    public Optional<User> findUserByEmail(@PathVariable String emailId){
        return userRepository.findByEmailId(emailId);
    }

    @DeleteMapping("/id/{id}")
    public void  deleteUserById(@PathVariable Long id){
       userRepository.deleteById(id);
       return;
    }

    @PutMapping("/id/{id}")
    public void updateUserById(@PathVariable Long id, @RequestBody User user){
        user.setUserId(id);
        userRepository.save(user);
        return;
    }

    //Todo: DeleteByEmailId Funktioniert noch nicht!
    @DeleteMapping("/email/{emailId}")
    public void  deleteUserByEmailId(@PathVariable String emailId) {
        userRepository.deleteByEmailId(emailId);
        return;
    }
}
