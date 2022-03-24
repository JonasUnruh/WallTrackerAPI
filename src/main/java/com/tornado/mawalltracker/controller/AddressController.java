package com.tornado.mawalltracker.controller;

import com.tornado.mawalltracker.data.Address;
import com.tornado.mawalltracker.data.AddressRepository;
import com.tornado.mawalltracker.data.RouteSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(path = "{id}")
    public ResponseEntity<Integer> getAddressById(@PathVariable("id") final Long id) {
        Optional<Address> opAddress = addressRepo.findById(id);
        if (opAddress.isEmpty()) {
            return new ResponseEntity<>(-1, HttpStatus.NOT_FOUND);
        }
        Address address = opAddress.get();
        return new ResponseEntity(address, HttpStatus.OK);
    }
}
