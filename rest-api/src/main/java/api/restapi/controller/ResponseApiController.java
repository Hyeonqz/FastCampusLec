package api.restapi.controller;

import api.restapi.dto.UserRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
public class ResponseApiController {

    @GetMapping("")
    public ResponseEntity<UserRequestDTO> user() {
        var user = new UserRequestDTO();

        var response = ResponseEntity
                .status(HttpStatus.OK)
                        .body(user);

        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("wlsgusrb78");
        return response;
    }
}
