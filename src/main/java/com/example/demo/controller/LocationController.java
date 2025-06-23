package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
/**
 * Controlador REST para gestionar las ubicaciones.
 */
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    /**
     * Devuelve todas las ubicaciones.
     */
    @GetMapping
    public List<Location> all() {
        return repository.findAll();
    }

    /**
     * Guarda una nueva ubicación.
     */
    @PostMapping
    public Location create(@RequestBody Location location) {
        return repository.save(location);
    }
}
