package com.jplan.authorizationserver.controllers;

import com.jplan.authorizationserver.services.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @GetMapping(value = "/get")
    public String testController() {
        logger.info("Run testController");

        logger.info(jwtTokenProvider.createToken());

        return "Hello Login Server!";
    }

    @PostMapping(value = "/get")
    public String testControllerPost() {
        logger.info("Run testController2");
        return "This is post test";
    }

    @PostMapping(value = "/post")
    public String testPostController(@RequestBody String body, HttpServletRequest req, HttpServletResponse res) {
        logger.info("Run testController");
        logger.info("Info is ==> {}", body);
        return "This is post";
    }
}
