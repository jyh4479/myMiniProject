package com.jplan.memberserver.controllers;

import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
