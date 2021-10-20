package com.jplan.authorizationserver.controllers;

import com.jplan.authorizationserver.dto.ErrorMessage;
import com.jplan.authorizationserver.dto.ResponseMessage;
import com.jplan.authorizationserver.dto.SignInData;
import com.jplan.authorizationserver.dto.SignUpData;
import com.jplan.authorizationserver.entities.Member;
import com.jplan.authorizationserver.services.JwtTokenProvider;
import com.jplan.authorizationserver.services.MemberService;
import com.jplan.authorizationserver.services.RedisProvider;
import com.jplan.authorizationserver.services.ResponseProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("/jplan")
public class LoginController {

    private final ResponseProvider responseProvider;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisProvider redisProvider;

    private final MemberService memberService;

    //https://great-developer.tistory.com/59
    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
    @PostMapping(value = "/signin")
    public ResponseEntity<?> memberSignInController(@RequestBody SignInData signInData, HttpServletResponse httpServletResponse) {
        try {
            log.info("Run memberSignInController");
            String id = signInData.getId();
            String password = signInData.getPassword();
            /* body 에 id와 password 를 받아올것 (앞단에서 정보 받는것에 대한 예외처리를 하지만 백단에서도 처리하도록 함) */

            /* decode logic & null logic 처리 */
            if (memberService.memberCheck(id, password)) {
                Member member = memberService.loadOneMember(id);
                
                httpServletResponse.setHeader("Access-Token", jwtTokenProvider.createAccessToken(id)); //access token is sent to browser
                redisProvider.setRedis(id, jwtTokenProvider.createRefreshToken(id)); //refresh token is saved to redis //refresh token is saved to redis

                log.info("Login Success!");
                ResponseMessage responseMessage = new ResponseMessage(999, "LOGIN::SUCCESS", member);
                return new ResponseEntity<>(responseMessage, HttpStatus.OK);
            }
            log.info("Login Fail!");
            ErrorMessage errorMessage = new ErrorMessage(999, "LOGIN::FAIL");
            return responseProvider.notFoundMessage(errorMessage);

        } catch (Exception e) {
            log.warning("Please check server status! --> " + e);
            return responseProvider.internalErrorMessage();
        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> memberSignInController(@RequestBody SignUpData signUpData) {
        log.info(signUpData.getEmail() + " get data from client");
        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public String testControllerPost() {
        log.info("Run testController2");
        return "This is get";
    }

    @PostMapping(value = "/post")
    public String testPostController(@RequestBody String body, HttpServletRequest req, HttpServletResponse res) {
        log.info("Run testController");
        log.info("Info is ==> " + body);
        return "This is post";
    }
}
