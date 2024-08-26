package com.demo.service;

import com.demo.entity.Airport;
import com.demo.repository.AirportRepository;
import com.demo.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public void createAirport(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

}



