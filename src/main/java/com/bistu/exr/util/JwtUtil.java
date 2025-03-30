package com.bistu.exr.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Value;

import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

public class JwtUtil {
    private static final String KEY = ResourceBundle.getBundle("application").getString("springweb.JWT.serect");

    private  static String genToken(Map<String,Object> claims){
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 *60 *60 *12))
                .sign(Algorithm.HMAC256(KEY));

    }

    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
