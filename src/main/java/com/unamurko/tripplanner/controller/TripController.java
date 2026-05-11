package com.unamurko.tripplanner.controller;

import com.unamurko.tripplanner.dto.TripDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    // temporary list to store all trips
    private List<TripDTO> trips = new ArrayList<>();
    private Long nextId = 1L;

    // GET /api/trips - get all trips
    @GetMapping
    public List<TripDTO> getTrips() {
        return trips;
    }

    // GET /api/trips/1 - get one specific trip
    @GetMapping("/{id}")
    public TripDTO getTrip(@PathVariable Long id) {
        return trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public TripDTO createTrip(@RequestBody TripDTO trip) {
        trip.setId(nextId++);
        trips.add(trip);
        return trip;
    }

    @DeleteMapping("/{id}")
    public String deleteTrip(@PathVariable Long id) {
        trips.removeIf(t -> t.getId().equals(id));
        return "Trip deleted.";
    }
}