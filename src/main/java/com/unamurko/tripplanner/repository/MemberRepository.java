package com.unamurko.tripplanner.repository;

import com.unamurko.tripplanner.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface MemberRepository  extends JpaRepository<Member, Long> {
    List<Member> findByTripId(Long tripId);
}
