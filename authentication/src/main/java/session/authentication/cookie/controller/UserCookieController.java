package session.authentication.cookie.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import session.authentication.cookie.db.CuserRepository;
import session.authentication.cookie.model.UserDto;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserCookieController {
    private final CuserRepository cuserRepository;


    // 쿠키 가져오는 방법1 (직접 찾아오기)
    @GetMapping("/me")
    public UserDto me (HttpServletRequest httpServletRequest) {

        var cookies = httpServletRequest.getCookies();

        if (cookies != null) {
            for(Cookie cookie : cookies) {
                log.info("key : {}, value: {}",cookie.getName(), cookie.getValue());
            }
        }
        return null;
    }

    // 쿠키 가져오는 방법2 (쿠키 받아오기)
    @GetMapping("/me2")
    public UserDto me2(HttpServletRequest httpServletRequest, @CookieValue(name = "authorization-cookie", required = false) String authorizationCookie) {
        log.info("{}",authorizationCookie);

        var userDto = cuserRepository.findById(authorizationCookie);

        return userDto.get(); //Json 값으로 가져오기
    }

    @GetMapping("/me3")
    public UserDto me3(@RequestHeader(name="authorization", required = false) String authorizationHeader) {
        log.info("authorizationHeader : {}", authorizationHeader);

        var optionalUserDto = cuserRepository.findById(authorizationHeader);
        return optionalUserDto.get();
    }
}
