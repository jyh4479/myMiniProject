package com.jplan.memberserver.controllers;

import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jplan/memberservice")
@RequiredArgsConstructor
public class MemberController {

    MemberService memberService;

    @GetMapping("/user")
    public Member getMemberData(@RequestBody String id) {
        return memberService.getMemberData(id);
    }
}
