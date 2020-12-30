package com.fhypayaso.tittytainment.modules.security.util;

import com.fhypayaso.tittytainment.modules.security.dto.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 9:26 上午
#   @Description   : 
# ====================================================*/
@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;


    public String generateToken(String phone) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", phone);
        return generateToken(claims);
    }


    /**
     * 根据 claims 生成 Token
     *
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(currentDate()) // 设置生成时间
                .setExpiration(expirationDate()) // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, this.secret.getBytes(StandardCharsets.UTF_8))
                .compact();
    }


    /**
     * 当前时间
     *
     * @return date
     */
    private Date currentDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 过期时间
     *
     * @return date
     */
    private Date expirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }


    /**
     * 解析token
     *
     * @param token token
     * @return Claims
     */
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(this.secret.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 判断token是否已经过期
     *
     * @param token token
     * @return 是否过期
     */
    private Boolean isTokenExpired(String token) {
        Claims claims = parseToken(token);
        Date expiration = claims.getExpiration();
        return expiration.before(currentDate());
    }


    /**
     * 从token中解析出phone
     *
     * @param token token
     * @return phone number
     */
    public String parsePhoneNumber(String token) {

        if (StringUtils.isEmpty(token))
            return null;

        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    public Date parseCreateDate(String token) {
        if (StringUtils.isEmpty(token))
            return null;
        Claims claims = parseToken(token);
        return claims.getIssuedAt();
    }

    /**
     * 检查 token 是否处于有效期内
     *
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        String phone = parsePhoneNumber(token);
        return !isTokenExpired(token) && phone.equals(user.getUsername());
    }

}
