package board.simpleboard.utility.controller;

import board.simpleboard.utility.Intercepter.OpenApi;
import board.simpleboard.utility.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@OpenApi
@Slf4j
@RequestMapping("/inter/user")
@RestController
public class UserController {

    @PostMapping
    @OpenApi
    public void register(@RequestBody UserRequest userRequest) {

        log.info("{}", userRequest);
    }

    @GetMapping("/hello")
    public void hello () {
        log.info("hello");
    }
}
