package org.example.api.domain.user.controller;

import org.example.api.common.api.Api;
import org.example.api.domain.token.controller.model.TokenResponse;
import org.example.api.domain.user.business.UserBusiness;
import org.example.api.domain.user.controller.model.req.UserLoginRequest;
import org.example.api.domain.user.controller.model.req.UserRegisterRequest;
import org.example.api.domain.user.controller.model.res.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
@RequestMapping("/open-api/user")
@RestController
public class UseOpenApiController {

	// 로그인 안해도 사용가능한 API
	private final UserBusiness userBusiness;

	// 사용자 회원 가입 요청
	@PostMapping("/register")
	public Api<UserResponse> register (@Valid @RequestBody Api<UserRegisterRequest> request) {

		var response = userBusiness.register(request.getBody());
		return Api.OK(response);
	}

	// 로그인
	@PostMapping("/login")
	public Api<TokenResponse> isLogin (@Valid @RequestBody Api<UserLoginRequest> request) {

		var response = userBusiness.login(request.getBody());
		return Api.OK(response);
	}

}
