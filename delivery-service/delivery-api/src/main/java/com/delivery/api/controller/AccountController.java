package com.delivery.api.controller;

import com.delivery.api.common.api.Api;
import com.delivery.api.common.error.UserErrorCode;
import com.delivery.db.account.AccountRepository;
import com.delivery.api.model.AccountMeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountController {
    private final AccountRepository accountRepository;


    @GetMapping("/me")
    public Api<Object> me() {
        var response =  AccountMeResponse.builder()
                .name("진현규")
                .email("jin@naver.com")
                .registerAt(LocalDateTime.now())
                .build();

        return Api.ERROR(UserErrorCode.USER_NOT_FOUND,"홍길동은 없다");
    }
}
