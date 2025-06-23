package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
/**
 * Entidad que representa una ubicación geográfica.
 */
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double latitude;
    private Double longitude;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    /** Identificador de la ubicación. */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    /** Nombre visible de la ubicación. */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /** Descripción opcional. */
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    /** Latitud geográfica. */
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    /** Longitud geográfica. */
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
