package com.unamurko.tripplanner.repository;

import com.unamurko.tripplanner.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
