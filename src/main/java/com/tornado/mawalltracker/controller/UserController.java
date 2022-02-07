package com.tornado.mawalltracker.controller;

import com.tornado.mawalltracker.data.User;
import com.tornado.mawalltracker.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Jonas Mum
 */
@RestController
@RequestMapping(path = "user")
@CrossOrigin(origins = "*")
public class UserController {

    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        this.userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}/getage")
    public ResponseEntity<Integer> getUserAge(@PathVariable("id") final Long id) {
        Optional<User> opUser = userRepo.findById(id);
        if (opUser.isEmpty()) {
            return new ResponseEntity<>(-1, HttpStatus.NOT_FOUND);
        }
        int age = opUser.get().getAge();
        return new ResponseEntity<>(age, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

}
