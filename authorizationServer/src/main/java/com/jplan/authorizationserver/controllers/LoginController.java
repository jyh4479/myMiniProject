package com.jplan.authorizationserver.controllers;

import com.jplan.authorizationserver.dto.LoginInfo;
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

    @PostMapping(value = "/get")
    public String testController(@RequestBody LoginInfo loginInfo, HttpServletResponse httpServletResponse) {

        logger.info("Run testController");

        String id = loginInfo.getId();
        String password = loginInfo.getPassword();

        /* body에 id와 password를 받아올것 (앞단에서 정보 받는것에 대한 예외처리를 하지만 백단에서도 처리하도록 함) */

        /* decode logic & null logic 처리 */

        //로그인 정보가 일치하는 경우 토큰 생성 후 레디스에 리프레쉬 토큰 저장 하고 엑세스 토큰 브라우져에 전달
        if (memberAuthService.memberCheck(id, password)) {
            httpServletResponse.setHeader("Token", jwtTokenProvider.createToken());
            logger.info("Login Success!");
            return "로그인 성공"; //jwtTokenProvider.createToken();
        }

        logger.info("Login Fail!");
        return "로그인 실패";
    }

    @GetMapping(value = "/get")
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
