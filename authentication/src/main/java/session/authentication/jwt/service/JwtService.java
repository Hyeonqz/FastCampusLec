package session.authentication.jwt.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

    private static String secretKey = "Java17SpringBoot3.2JWTTOKENIssueMethodTest";

    public String createToken (Map<String,Object> claims, LocalDateTime expireAt) {

        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

        // DateTime -> Date 로 바꿔주는 로직
        var _expiredAt = Date.from(expireAt.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setClaims(claims)
                .setExpiration(_expiredAt)
                .compact();
    }

    public void validationToken (String token) {
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        var parser = Jwts.parser()
                .setSigningKey(key)
                .build();
        try {
            var result = parser.parseClaimsJws(token);

            result.getBody().entrySet().forEach(value -> {
                log.info("key : {}, value : {}", value.getKey(), value.getValue());
            });
        } catch (Exception ignored) {
            if (ignored instanceof SignatureException) {
                throw new RuntimeException("JWT Token Not valid Exception");
            } else if (ignored instanceof ExpiredJwtException) {
                throw new RuntimeException("JWT Token Expired Exception");
            } else {
                throw new RuntimeException("JWT Token 알수없는 validation Exception");
            }
        }


    }
}
