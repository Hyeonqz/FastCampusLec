package session.authentication.jwt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void tokenCreate() {
        var claims = new HashMap<String, Object>();
        claims.put("user_id",923);

        var expiredAt = LocalDateTime.now().plusMinutes(30);

        var jwtToken = jwtService.createToken(claims,expiredAt);
        System.out.println(jwtToken);
    }

    @Test
    void tokenValidation () {
        String token1 = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTcxMDc1NDY5Mn0.L5kj22QWW2umf9sWu1Dl9njpPIk7YcQd_OYeQ8VGPOY";
        jwtService.validationToken(token1);
    }

}