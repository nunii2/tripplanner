package com.unamurko.tripplanner.controller;

import com.unamurko.tripplanner.entity.Member;
import com.unamurko.tripplanner.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    //GET /api/trips/1/members - get all members for a trip
    @GetMapping("/{tripId}/members")
    public List<Member> getMembers(@PathVariable Long tripId) {
        return memberService.getMembersByTripId(tripId);
    }

    //GET /api/trips/1/members/1 - get one specific member
    @GetMapping("/{tripId}/members/{id}")
    public Member getMember(@PathVariable Long tripId, @PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    //POST /api/trips/1/members - create member for a trip
    @PostMapping("/{tripId}/members")
    public Member createMember(@PathVariable Long tripId, @RequestBody Member member) {
        member.setTripId(tripId); //autumatically set tripId from the URL
        return memberService.createMember(member);
    }

    @DeleteMapping("/{tripId}/members/{id}")
    public String deleteMember(@PathVariable Long tripId, @PathVariable Long id) {
        memberService.deleteMember(id);
        return "Member deleted";
    }

}
