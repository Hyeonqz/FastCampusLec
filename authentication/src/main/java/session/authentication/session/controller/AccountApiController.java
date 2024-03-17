package session.authentication.session.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import session.authentication.session.dto.LoginRequest;
import session.authentication.session.service.UserService;


@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountApiController {

    private final UserService userservice;
    @PostMapping("/login")
    public void login (@RequestBody LoginRequest loginRequest, HttpSession httpSession) {
        userservice.login(loginRequest,httpSession);
    }
}
