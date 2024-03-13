package db.jpa.user.controller;

import db.jpa.user.db.UserEntity;
import db.jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/find-all")
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/name")
    public void autoSave(@RequestParam String name) {
        var user = UserEntity.builder()
                .name(name)
                .build();
        // insert into (name) user values ('큐뱅'); 과 같다.
        userRepository.save(user);
    }
}
