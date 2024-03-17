package session.authentication.session.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import session.authentication.session.dto.UserDto;

@RequestMapping("/api/user")
@RestController
public class UserApiController {

    // 나의 정보를 불러오는 API
    @GetMapping("/me")
    public UserDto me (HttpSession httpSession) {
        var userObject = httpSession.getAttribute("USER");

        if (userObject != null) {
            var userDto = (UserDto)userObject;
            return userDto;
        }
        else {
            return null;
        }
    }
}
