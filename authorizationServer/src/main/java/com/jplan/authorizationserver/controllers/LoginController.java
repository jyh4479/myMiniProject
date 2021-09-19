package com.jplan.authorizationserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class LoginController {

    @GetMapping(value="/get")
    public String testController() {
        return "Hello Login Server!";
    }
}
