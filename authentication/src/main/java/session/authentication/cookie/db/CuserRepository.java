package session.authentication.cookie.db;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import session.authentication.cookie.model.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CuserRepository {

    private final List<UserDto> list = new ArrayList<>();

    // userDto 를 찾아오는 로직
    public Optional<UserDto> findById(String id) {
        return list.stream().filter(
                it -> {
                    return it.getId().equals(id);
                }
        ).findFirst();
    }

    public Optional<UserDto> findByName(String name) {
        return list.stream()
                .filter( it -> {
                    return it.getName().equals(name);
                })
                .findFirst();
    }


    @PostConstruct // Bean 이 초기화 되고 호출을 한다.
    public void init() {
        list.add(new UserDto(
                UUID.randomUUID().toString(),
                "홍길동",
                "1234"//Random ID 생성 로직
        ));
        list.add(new UserDto(
                UUID.randomUUID().toString(),
                "홍준표",
                "1234"//Random ID 생성 로직
        ));
        list.add(new UserDto(
                UUID.randomUUID().toString(),
                "홍재근",
                "1234"//Random ID 생성 로직
        ));
    }

}
