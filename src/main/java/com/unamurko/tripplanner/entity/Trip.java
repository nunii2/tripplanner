package com.unamurko.tripplanner.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity //this springclass maps to database table
@Table(name = "trips") //names table trips in PostgreSQl
@Data

public class Trip {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increments ID
    private Long id;

    private String name;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;

}
