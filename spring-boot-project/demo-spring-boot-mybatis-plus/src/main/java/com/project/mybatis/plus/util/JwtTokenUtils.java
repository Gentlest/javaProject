package com.project.mybatis.plus.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类
 *
 * @Author Gentlest
 * @Date 2021/3/30 15:08
 */
@Slf4j
public class JwtTokenUtils implements Serializable {

    private static final long serialVersionUID = -3812595767036828461L;
    /**
     * 秘钥
     */
    private static final String SECRET_KEY = "2dodging";
    /**
     * 过期时间
     */
    private static final long EXPIRATION_TIME = 900_000;
    private static final String CLAIMS_KEY_NAME = "sub";
    private static final String CLAIMS_KEY_CREATED = "created";


    /**
     * 根据负载信息生成twt的token
     */
    public String generateToken(Map<String, Object> claims) {

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationTime())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

    }

    /**
     * 解析token
     */
    public Claims parseToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.debug("token格式验证失败:", e);
        }
        return claims;
    }

    /**
     * 生成token过期时间
     */
    private Date generateExpirationTime() {
        return new Date(System.currentTimeMillis() + EXPIRATION_TIME);
    }

    /**
     * 验证token是否有效
     *
     * @param token       客户端传递过来的token
     * @param userDetails 数据库中查询出来的信息
     */
    public boolean verifyToken(String token, UserDetails userDetails) {
        Claims claims = parseToken(token);
        String username = claims.getSubject();
        return username.equals(userDetails.getUsername()) && !isExpirationTime(token);
    }

    /**
     * 判断token是否过期
     */
    public boolean isExpirationTime(String token) {
        Claims claims = parseToken(token);
        Date expirationDate = claims.getExpiration();
        return expirationDate.before(new Date());
    }

    /**
     * 根据用户信息生成token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIMS_KEY_NAME, userDetails.getUsername());
        claims.put(CLAIMS_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 刷新token
     */
    public String refreshToken(String token) {
        Claims claims = parseToken(token);
        claims.put(CLAIMS_KEY_CREATED, new Date());
        return generateToken(claims);
    }

}