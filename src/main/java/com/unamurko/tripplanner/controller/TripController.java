package com.unamurko.tripplanner.controller;

import com.unamurko.tripplanner.entity.Trip;
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
    public List<Trip> getTrips() {
        return tripService.getAllTrips();
    }

    // GET /api/trips/1 - get one specific trip
    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @DeleteMapping("/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "Trip deleted.";
    }
}