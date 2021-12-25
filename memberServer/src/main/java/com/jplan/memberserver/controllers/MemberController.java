package com.jplan.memberserver.controllers;

import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/jplan/memberservice")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public Member getMemberData(@RequestParam("id") String id) {
        log.info("run getmemberData");
        Member member = memberService.getMemberData(id);
        System.out.println(member);
        return member;
    }

    @PostMapping("/chattingroom")
    public ResponseEntity<?> WebClientTest(@RequestBody Integer id) {
        log.info("member server get id from chat server!" + id);
        return new ResponseEntity<>(id, null, HttpStatus.NOT_FOUND);
    }
}
