package com.jplan.authorizationserver.controllers;

import com.jplan.authorizationserver.services.JwtTokenProvider;
import com.jplan.authorizationserver.services.MemberAuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberAuthService memberAuthService;

    @GetMapping(value = "/get")
    public String testController(HttpServletResponse httpServletResponse) {

        logger.info("Run testController");
        logger.info(jwtTokenProvider.createToken());

        if (memberAuthService.memberCheck("ID", "PASSWORD")) {
            jwtTokenProvider.createToken();
        }

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
