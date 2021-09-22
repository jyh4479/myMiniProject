package com.jplan.memberserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @GetMapping("/")
    public String memberTest(){
        return "Hello Member!";
    }
}
