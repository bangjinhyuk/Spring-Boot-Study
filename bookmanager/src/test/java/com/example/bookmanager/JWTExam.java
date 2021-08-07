package com.example.bookmanager;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * Created by bangjinhyuk on 2021/08/07.
 */
@SpringBootTest
public class JWTExam {

    private void printToken(String token){
        String[] tokens = token.split("\\.");
        System.out.println("header: " + new String(Base64.getDecoder().decode(tokens[0])));
        System.out.println("body: " + new String(Base64.getDecoder().decode(tokens[1])));
    }

    @Test
    void Test1(){
        String okta_token = Jwts.builder().addClaims(
                Map.of("name","bang","price",3000)
                ).signWith(SignatureAlgorithm.HS256,"bang")
                .compact();
        System.out.println(okta_token);
        printToken(okta_token);

        Jws<Claims> tokenInfo = Jwts.parser().setSigningKey("bang").parseClaimsJws(okta_token);
        System.out.println(tokenInfo);

    }

    @Test
    void Test2(){
        String oauth0_token = JWT.create().withClaim("name","bang").withClaim("price",3000)
                .sign(Algorithm.HMAC256("bang"));
        System.out.println(oauth0_token);
        printToken(oauth0_token);

        DecodedJWT verified = JWT.require(Algorithm.HMAC256("bang")).build().verify(oauth0_token);
        System.out.println(verified);

    }

    @DisplayName("만료시간 테스트")
    @Test
    void Test3() throws InterruptedException {
        final Algorithm AL = Algorithm.HMAC256("bang");
        String token = JWT.create().withSubject("a1234")
                .withNotBefore(new Date(System.currentTimeMillis() + 1000))
                .withExpiresAt(new Date(System.currentTimeMillis() + 3000))
                .sign(AL);

        Thread.sleep(4000);
        DecodedJWT verify = JWT.require(AL).build().verify(token);

        System.out.println(verify.getClaims());
    }
}
