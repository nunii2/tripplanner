package com.unamurko.tripplanner.controller;

import com.unamurko.tripplanner.dto.TripDTO;
import com.unamurko.tripplanner.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    // GET /api/trips - get all trips
    @GetMapping
    public List<TripDTO> getTrips() {
        return tripService.getAllTrips();
    }

    // GET /api/trips/1 - get one specific trip
    @GetMapping("/{id}")
    public TripDTO getTrip(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PostMapping
    public TripDTO createTrip(@RequestBody TripDTO trip) {
        return tripService.createTrip(trip);
    }

    @DeleteMapping("/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "Trip deleted.";
    }
}