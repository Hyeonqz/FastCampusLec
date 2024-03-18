package session.authentication.session.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import session.authentication.cookie.model.LoginRequest;
import session.authentication.cookie.db.CuserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final CuserRepository userRepository;


    public void login (LoginRequest loginRequest, HttpSession httpSession) {
        var id = loginRequest.getId();
        var password = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto =optionalUser.get();

            if (userDto.getPassword().equals(password)) {
                httpSession.setAttribute("USER",userDto);
            }
            else {
                throw new RuntimeException("비밀번호가 맞지 않습니다.");
            }
        }
        else {
            throw new RuntimeException("유저를 찾을 수 없습니다.");
        }
    }
}
