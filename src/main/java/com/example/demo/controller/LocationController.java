package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Location> all() {
        return repository.findAll();
    }

    @PostMapping
    public Location create(@RequestBody Location location) {
        return repository.save(location);
    }
}
