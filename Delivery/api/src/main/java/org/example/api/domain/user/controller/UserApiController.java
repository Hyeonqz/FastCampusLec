package org.example.api.domain.user.controller;

import java.util.Objects;

import org.example.api.common.api.Api;
import org.example.api.domain.user.business.UserBusiness;
import org.example.api.domain.user.controller.model.res.UserResponse;
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
	public Api<UserResponse> me() {
		var requestContext = Objects.requireNonNull(RequestContextHolder.getRequestAttributes());
		var userID = requestContext.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);
		var response = userBusiness.me(Long.parseLong(userID.toString()));
		return Api.OK(response);
	}
}
