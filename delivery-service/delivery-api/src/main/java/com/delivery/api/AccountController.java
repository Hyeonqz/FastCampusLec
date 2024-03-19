package com.delivery.api;

import com.delivery.db.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountController {
    private final AccountRepository accountRepository;


    @GetMapping()
    public void save() {
        accountRepository.save(null);
    }
}
