package com.jplan.authorizationserver.controllers;

import com.jplan.authorizationserver.dto.ErrorMessage;
import com.jplan.authorizationserver.dto.ResponseMessage;
import com.jplan.authorizationserver.dto.SignInData;
import com.jplan.authorizationserver.dto.SignUpData;
import com.jplan.authorizationserver.entities.Member;
import com.jplan.authorizationserver.services.JwtTokenProvider;
import com.jplan.authorizationserver.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jplan")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;
    private final StringRedisTemplate stringRedisTemplate;

    //https://great-developer.tistory.com/59
    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
    @PostMapping(value = "/signin")
    public ResponseEntity<?> memberSignInController(@RequestBody SignInData signInData) {
        try {
            logger.info("Run testController");
            String id = signInData.getId();
            String password = signInData.getPassword();
            /* body 에 id와 password 를 받아올것 (앞단에서 정보 받는것에 대한 예외처리를 하지만 백단에서도 처리하도록 함) */

            /* decode logic & null logic 처리 */
            if (memberService.memberCheck(id, password)) {
                Member member = memberService.loadOneMember(id);

                HttpHeaders responseHeader = new HttpHeaders();
                ValueOperations<String, String> vop = stringRedisTemplate.opsForValue();

                responseHeader.add("Access-Token", jwtTokenProvider.createAccessToken(id)); //access token is sent to browser
                vop.set(id, jwtTokenProvider.createRefreshToken(id)); //refresh token is saved to redis

                ResponseMessage responseMessage = new ResponseMessage(999, "LOGIN::SUCCESS", member);

                logger.info("Login Success!");
                return new ResponseEntity<>(responseMessage, responseHeader, HttpStatus.OK);
            }

            logger.info("Login Fail!");
            ErrorMessage errorMessage = new ErrorMessage(999, "LOGIN::FAIL");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            logger.info("Please check server status!");
            ErrorMessage errorMessage = new ErrorMessage(999, "SERVER::ERROR");
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> memberSignInController(@RequestBody SignUpData signUpData) {
        logger.info("{} get data from client", signUpData.getEmail());
        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public String testControllerPost() {
        logger.info("Run testController2");
        return "This is get";
    }

    @PostMapping(value = "/post")
    public String testPostController(@RequestBody String body, HttpServletRequest req, HttpServletResponse res) {
        logger.info("Run testController");
        logger.info("Info is ==> {}", body);
        return "This is post";
    }
}
