package com.jplan.authorizationserver.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//https://aejeong.com/entry/Spring-boot-JWT-RefreshToken-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
//토큰 구현 참고
@Service
public class JwtTokenProvider {

    private final String ACCESS_KEY = "accessKey";
    private final String REFRESH_KEY = "refreshKey";
    private final String DATA_KEY = "userId";

    public String createAccessToken(String id) {
        return Jwts.builder()
                .setSubject(id)
                .setHeader(createHeader("Access-Token"))
                .setClaims(createClaims(id))
                .setExpiration(createExpireDate(1000 * 60 * 5))
                .signWith(SignatureAlgorithm.HS256, createSigningKey(ACCESS_KEY))
                .compact();
    }

    public String createRefreshToken(String id) {
        return Jwts.builder()
                .setSubject(id)
                .setHeader(createHeader("Refresh-Token"))
                .setClaims(createClaims(id))
                .setExpiration(createExpireDate(1000 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, createSigningKey(REFRESH_KEY))
                .compact();
    }

    private Date createExpireDate(long expireDate) {
        long curTime = System.currentTimeMillis();
        return new Date(curTime + expireDate);
    }

    private Map<String, Object> createHeader(String tokenType) {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", tokenType);
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());

        return header;
    }

    private Map<String, Object> createClaims(String id) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(DATA_KEY, id);
        return claims;
    }

    private Key createSigningKey(String key) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
    }
}
