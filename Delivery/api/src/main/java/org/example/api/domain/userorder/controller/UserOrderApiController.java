package org.example.api.domain.userorder.controller;

import java.util.List;

import org.example.api.common.annotation.UserSession;
import org.example.api.common.api.Api;
import org.example.api.domain.user.model.User;
import org.example.api.domain.userorder.business.UserOrderBusiness;
import org.example.api.domain.userorder.controller.model.UserOrderDetailResponse;
import org.example.api.domain.userorder.controller.model.UserOrderRequest;
import org.example.api.domain.userorder.controller.model.UserOrderResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/user-order")
@RequiredArgsConstructor
@RestController
public class UserOrderApiController {

	private final UserOrderBusiness userOrderBusiness;

	// 사용자 주문
	@PostMapping("")
	public Api<UserOrderResponse> userOrder (
		@Valid @RequestBody Api<UserOrderRequest> userOrderRequest,
		@Parameter(hidden = true)
		@UserSession User user // 스웨거에서 파라미터로 인식하므로 안되게 만들어야 한다.
	) {
		var response = userOrderBusiness.userOrder(user, userOrderRequest.getBody());
		return Api.OK(response);
	}

	// 현재 진행중인 주문건
	@GetMapping("/current")
	public Api<List<UserOrderDetailResponse>> currentOrder (@Parameter(hidden = true)@UserSession User user) {
		var response = userOrderBusiness.current(user);
		return Api.OK(response);
	}

	// 과거 주문 내역
	@GetMapping("/history")
	public Api<List<UserOrderDetailResponse>> historyOrder (@Parameter(hidden = true)@UserSession User user) {
		var response = userOrderBusiness.history(user);
		return Api.OK(response);
	}


	// 주문 1건에 대한 내역
	@GetMapping("/id/{orderId}")
	public Api<UserOrderDetailResponse> readOrder (@Parameter(hidden = true)@UserSession User user, @PathVariable Long orderId) {
		var response = userOrderBusiness.read(user,orderId);
		return Api.OK(response);
	}


}
