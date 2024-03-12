package database.com.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import database.com.user.model.UserEntity;
import database.com.user.service.UserService;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public UserEntity findOne (@PathVariable Long id) {
        var response = userService.findById(id);
        return response.get();
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }


}
