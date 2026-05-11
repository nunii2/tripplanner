package com.unamurko.tripplanner.repository;

import com.unamurko.tripplanner.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    List<Expense> findByTripId(Long tripId);
}
