package com.tornado.mawalltracker.controller;

import com.tornado.mawalltracker.data.Address;
import com.tornado.mawalltracker.data.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "address")
@CrossOrigin(origins = "*")
public class AddressController {

    private AddressRepository addressRepo;

    @Autowired
    public AddressController(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody final Address address) {
        this.addressRepo.save(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Address>> getAllAddresses() {
        return new ResponseEntity<>(addressRepo.findAll(), HttpStatus.OK);
    }
}
