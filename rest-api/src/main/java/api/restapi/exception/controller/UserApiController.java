package api.restapi.exception.controller;

import api.restapi.exception.model.Api;
import api.restapi.exception.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserApiController {
    private static List<UserResponse> list = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(12)
                    .name("kyu")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(13)
                    .name("hyeon")
                    .build()
    );

    @GetMapping("/id/{id}")
    public Api<UserResponse> getUser(@PathVariable String id) {
        var user = list.stream()
                .filter(it -> it.getId()
                        .equals(id))
                .findFirst()
                .get();

        Api<UserResponse> responseApi = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();

        return responseApi;
    }
}
