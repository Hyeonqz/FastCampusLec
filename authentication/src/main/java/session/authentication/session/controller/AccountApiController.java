package session.authentication.session.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import session.authentication.cookie.model.LoginRequest;
import session.authentication.cookie.service.CuserService;


@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountApiController {

    private final CuserService userservice;
    @PostMapping("/session")
    public void login (@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        userservice.login(loginRequest,response);
    }
}
