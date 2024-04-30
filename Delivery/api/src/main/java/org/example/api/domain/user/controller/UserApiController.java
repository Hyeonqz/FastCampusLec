package org.example.api.domain.user.controller;

import java.util.Objects;

import org.example.api.common.annotation.UserSession;
import org.example.api.common.api.Api;
import org.example.api.domain.user.business.UserBusiness;
import org.example.api.domain.user.controller.model.res.UserResponse;
import org.example.api.domain.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserApiController {
	// 로그인을 해야지 사용가능한 API
	private final UserBusiness userBusiness;

	@GetMapping("/me")
	public Api<UserResponse> me(@UserSession User user) { // AOP 방식으로 진행을 함.

		var response = userBusiness.me(user.getId());
		return Api.OK(response);
	}
}
