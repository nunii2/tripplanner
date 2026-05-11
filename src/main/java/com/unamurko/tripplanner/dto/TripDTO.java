package com.unamurko.tripplanner.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TripDTO {
    private Long id;
    private String name;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
}
