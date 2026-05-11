package com.unamurko.tripplanner.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "expenses")
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double amount;
    private String paidBy;
    private Long tripId;
}
