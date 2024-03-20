package com.delivery.api.controller;

import com.delivery.api.common.api.Api;
import com.delivery.api.common.error.UserErrorCode;
import com.delivery.api.model.AccountMeResponse;
import com.delivery.db.account.AccountRepository;
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
        var response = AccountMeResponse.builder()
                .name("김연성")
                .email("kiteStar@naver.com")
                .registerAt(LocalDateTime.now())
                .build();

        return Api.ERROR(UserErrorCode.USER_NOT_FOUND, "김연성은 갔다");
    }


}
