package com.example.demo.jsf;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;

import java.io.Serializable;
import java.util.List;

public class LocationFormBean implements Serializable {
    private LocationRepository repository;
    private Location location = new Location();

    public void setRepository(LocationRepository repository) {
        this.repository = repository;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Location> getLocations() {
        return repository.findAll();
    }

    public String save() {
        repository.save(location);
        location = new Location();
        return "index?faces-redirect=true";
    }
}
