package session.authentication.session.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import session.authentication.session.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<UserDto> userList = new ArrayList<>();

    // 즉 Optional 은 반환값에 뭐가 올지 모를 때 이것을 사용한다
    public Optional<UserDto> findByName(String name) {
        return userList
                .stream()
                .filter(it -> {
            return it.getName().equals(name);
        }).findFirst(); // 제일 첫번째 것을 반환하는 메소드


    }

    // Bean 이 초기화가 되었을 떄 불려오도록 하는 어노테이션이다
    @PostConstruct
    public void init() {
        // bean 이 초기화 되면 호출이 된다.
        userList.add(new UserDto("홍길동","1234"));
        userList.add(new UserDto("홍범도","1234"));
        userList.add(new UserDto("홍기륜","1234"));
    }

}
