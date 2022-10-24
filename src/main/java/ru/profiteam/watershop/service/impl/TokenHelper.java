package ru.profiteam.watershop.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hibernate.type.descriptor.java.JdbcDateTypeDescriptor.DATE_FORMAT;

@UtilityClass
public class TokenHelper {

    private final String SIGNING_KEY = "342";


    public String buildToken(Long userId) {
        List<GrantedAuthority> auths = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        auths.add(new SimpleGrantedAuthority(String.valueOf(userId)));

        Date tokenLife = Date.from(Instant.now().plusSeconds(315360000));
        return Jwts.builder()
                .claim("authorities", auths.stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(tokenLife)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY.getBytes())
                .compact();
    }

    public Long parseJwt(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SIGNING_KEY.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            List<String> authorities = claims.get("authorities", List.class);
            return authorities.stream().findFirst().map(Long::parseLong).orElse(0L);
        } catch (Exception ex) {
            return null;
        }
    }
}
