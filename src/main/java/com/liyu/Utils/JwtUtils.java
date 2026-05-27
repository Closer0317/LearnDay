package com.liyu.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String SECRET_KEY = "bGl5dQo=";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7;

    // 生成令牌
    public static String generateToken(Map<String, Object>  claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    //解析令牌
    public static Claims parseToken(String token)throws  Exception {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
