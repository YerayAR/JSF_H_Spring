package com.example.demo.repository;

import com.example.demo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Repositorio de acceso a la tabla de ubicaciones.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
}
