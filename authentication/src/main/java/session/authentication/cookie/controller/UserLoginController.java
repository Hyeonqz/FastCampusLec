package session.authentication.cookie.controller;

import jakarta.servlet.http.HttpServletResponse;
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
public class UserLoginController {

    private final CuserService cuserService;
    @PostMapping("/login")
    public void login (@RequestBody LoginRequest loginRequest, HttpServletResponse httpServletResponse) {
        cuserService.login(loginRequest,httpServletResponse);
    }
}
