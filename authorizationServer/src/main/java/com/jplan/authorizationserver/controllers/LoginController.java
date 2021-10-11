package com.jplan.authorizationserver.controllers;

import com.jplan.authorizationserver.dto.ErrorMessage;
import com.jplan.authorizationserver.dto.LoginInfo;
import com.jplan.authorizationserver.dto.ResponseMessage;
import com.jplan.authorizationserver.entities.Member;
import com.jplan.authorizationserver.services.JwtTokenProvider;
import com.jplan.authorizationserver.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;

    //https://great-developer.tistory.com/59
    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
    @PostMapping(value = "/get")
    public ResponseEntity<?> testController(@RequestBody LoginInfo loginInfo, HttpServletResponse httpServletResponse) {
        try {
            logger.info("Run testController");
            String id = loginInfo.getId();
            String password = loginInfo.getPassword();
            /* body에 id와 password를 받아올것 (앞단에서 정보 받는것에 대한 예외처리를 하지만 백단에서도 처리하도록 함) */

            /* decode logic & null logic 처리 */

            //로그인 정보가 일치하는 경우 토큰 생성 후 레디스에 리프레쉬 토큰 저장 하고 엑세스 토큰 브라우져에 전달

            if (memberService.memberCheck(id, password)) {
                Member member = memberService.loadOneMember(id);

                //httpServletResponse.setHeader("Token", jwtTokenProvider.createToken());

                HttpHeaders responseHeader = new HttpHeaders();
                responseHeader.add("Access-Token", jwtTokenProvider.createAccessToken(id));

                ResponseMessage responseMessage = new ResponseMessage(999, "LOGIN::SUCCESS", member);

                logger.info("Login Success!");
                return new ResponseEntity<ResponseMessage>(responseMessage, responseHeader, HttpStatus.OK);
            }

            logger.info("Login Fail!");
            ErrorMessage errorMessage = new ErrorMessage(999, "LOGIN::FAIL");
            return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            logger.info("Please check server status!");
            ErrorMessage errorMessage = new ErrorMessage(999, "SERVER::ERROR");
            return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
