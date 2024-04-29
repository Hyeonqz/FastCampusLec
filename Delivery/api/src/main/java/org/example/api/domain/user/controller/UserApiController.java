package org.example.api.domain.user.controller;

import org.example.api.domain.user.business.UserBusiness;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserApiController {
	// 로그인을 해야지 사용가능한 API
	private final UserBusiness userBusiness;
}
