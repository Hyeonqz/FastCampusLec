package api.restapi.controller;

import api.restapi.dto.BookRequest;
import api.restapi.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
public class PostApiController {

    @PostMapping("/post")
    public String post(@RequestBody BookRequest bookRequest) {
        // post,put에서 Httpbody로 들어오는 값을 해당 객체에다가 매핑을 하겠다는 뜻, 기본이 JSON
        // JSON은 문자, 숫자, Boolean, Object, Array 를 다를 수 있다
        System.out.println(bookRequest);
        return bookRequest.toString();

        // return 타입에 따라 스프링에서는 반환 방식이 달라지고
        // content-type이 달라진다.
        // 객체를 반환하면 자동으로 JSON 으로 처리가 된다
    }

    @PostMapping("/user")
    public ResponseEntity<User> user(@RequestBody User user) {
        return ResponseEntity.ok(user);
        // new ResponseEntity<>(user, HttpStatus.OK);
    }
}
