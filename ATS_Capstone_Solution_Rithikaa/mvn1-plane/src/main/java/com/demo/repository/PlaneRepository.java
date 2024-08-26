package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.entity.Plane;

import java.util.Optional;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Optional<Plane> findByPlaneCode(String planeCode);
}



