package com.jplan.authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//https://bcp0109.tistory.com/301 --> 인증 로직 참고

//https://koogood.tistory.com/m/25?category=756037 --> JWT 생성 참고

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication
public class AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

}
