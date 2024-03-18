package session.authentication.cookie.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import session.authentication.cookie.db.CuserRepository;
import session.authentication.cookie.model.LoginRequest;

@RequiredArgsConstructor
@Service
public class CuserService {
    private final CuserRepository cuserRepository;

    // 로그인 로직
    public void login (LoginRequest loginRequest, HttpServletResponse httpServletResponse) {
        String id = loginRequest.getId();
        String password = loginRequest.getPassword();

        var optionUser = cuserRepository.findByName(id);

        if (optionUser.isPresent()) {
            var userDto = optionUser.get();

            if (userDto.getPassword().equals(password)) {
                // Cookie 에 해당 정보를 저장
                Cookie cookie = new Cookie("authorization-cookie", userDto.getId());
                // cookie 는 특정 도메인에서만 활용할 수 있다.
                cookie.setDomain("localhost");
                // 특정 경로에서만 지정한다
                cookie.setPath("/");
                cookie.setMaxAge(-1); // 세션과 동일하게, 세션이 연결된 동안 만 사용한다
                cookie.setHttpOnly(true); // session 이 유지될 때만 쿠키가 있게 끔 한다.
                cookie.setSecure(true); // https 에서만 사용가능하게 끔 만듬.
                httpServletResponse.addCookie(cookie); // servlet 에 cookie 를 추가해준다.
            }
        } else {
            throw new RuntimeException("User 를 찾을 수 없습니다.");
        }
    }

}
