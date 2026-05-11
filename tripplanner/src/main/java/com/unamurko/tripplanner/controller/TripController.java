package com.unamurko.tripplanner.controller;

import com.unamurko.tripplanner.dto.TripDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @GetMapping
    public List<TripDTO> getTrips() {
        TripDTO trip1 = new TripDTO();
        trip1.setId(1L);
        trip1.setName("Iceland Trip");
        trip1.setDestination("Reykjavik");
        trip1.setStartDate(LocalDate.of(2026, 8, 7));
        trip1.setEndDate(LocalDate.of(2026, 8, 19));

        TripDTO trip2 = new TripDTO();
        trip2.setId(2L);
        trip2.setName("Bohinj");
        trip2.setDestination("Ukanc");
        trip2.setStartDate(LocalDate.of(2026, 7, 31));
        trip2.setEndDate(LocalDate.of(2026, 8, 3));

        return List.of(trip1, trip2);
    }
}
