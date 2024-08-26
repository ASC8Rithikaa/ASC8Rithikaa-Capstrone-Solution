package com.demo.service;

import com.demo.entity.Airport;

import java.util.List;

public interface AirportService {
    void createAirport(Airport airport);
    List<Airport> getAllAirports();
}
