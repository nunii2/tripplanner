package com.unamurko.tripplanner.service;

import com.unamurko.tripplanner.dto.TripDTO;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TripService {

    private List<TripDTO> trips = new ArrayList<>();
    private Long nextId = 1L;

    public List<TripDTO> getAllTrips() {
        return trips;
    }

    public TripDTO getTripById(Long id) {
        return trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public TripDTO createTrip(TripDTO trip) {
        trip.setId(nextId++);
        trips.add(trip);
        return trip;
    }

    public void deleteTrip(Long id) {
        trips.removeIf(t -> t.getId().equals(id));
    }
}
