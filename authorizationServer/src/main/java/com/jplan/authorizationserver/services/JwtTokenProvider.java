package com.jplan.authorizationserver.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider {
    private PrivateKey privateKey;
    private final long tokenValidTime = 60 * 30 * 1000L;

    public String createToken() {
        Claims claims = Jwts.claims().setSubject("PAYLOAD!!");
        claims.put("roles", "ROLES!!");
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        Date now = new Date();

        return Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time 언제까지 유효한지.
//                .signWith(SignatureAlgorithm.RS256, "secret")  // 사용할 암호화 알고리즘과
                .signWith(SignatureAlgorithm.HS256, "secret")  // 사용할 암호화 알고리즘과
                .setIssuer("jyh")
                .setId("JEONG_YONG_HOON!!")

                .compact();

//        Date now = new Date();

//        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
//                .setIssuer("fresh") // (2)
//                .setIssuedAt(now) // (3)
//                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis())) // (4)
//                .claim("id", "아이디") // (5)
//                .claim("email", "ajufresh@gmail.com")
//                .signWith(SignatureAlgorithm.HS256, "secret") // (6)
//                .compact();
    }
}
