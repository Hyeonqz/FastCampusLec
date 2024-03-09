package spring.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Api;
import spring.model.UserRegister;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/api/user")
@RestController
public class UserController {

    @PostMapping
    public Api<UserRegister> register ( //제네릭을 와일드 타입을 사용한다. 어떠한 탑을 받을지 모를 때 사용하자.
                                                           @Valid
            @RequestBody Api<UserRegister> userRegister ,
                                        BindingResult bindingResult) { //에러 잡을 때 사용하는 것. -> 해당 valid가 실행되었을 때 값을 bindingresult에 담아준다.
        // @Valid 어노테이션이 붙어 있으면
        /* 요청이 들어 올때 자동으로 헤당 어노테이션 기반으로 검증을 해준다.
        * */


        log.info("init : {} " , userRegister);

        var body = userRegister.getData();


        Api<UserRegister> response = Api.<UserRegister>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value())) //성공한 값
                .resultMessage(HttpStatus.OK.getReasonPhrase()) //성공한 이유
                .data(body)
                .build();

        return response;
    }
}

