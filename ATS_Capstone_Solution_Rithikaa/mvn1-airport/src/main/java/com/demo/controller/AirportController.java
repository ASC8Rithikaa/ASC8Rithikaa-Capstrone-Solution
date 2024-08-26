package com.demo.controller;

import com.demo.entity.Airport;
import com.demo.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/create")
    public ResponseEntity<String> createAirport(@RequestBody Airport airport) {
        try {
            airportService.createAirport(airport);
            return new ResponseEntity<>("Airport created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create airport: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/display")
    public ResponseEntity<List<Airport>> displayAirports() {
        List<Airport> airports = airportService.getAllAirports();
        if (airports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }
}


