package com.jplan.memberserver.controllers;

import com.jplan.memberserver.repositories.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String memberTest() {

        System.out.println(memberRepository.getById("jyh4479"));

        return "Hello Member!";
    }
}
