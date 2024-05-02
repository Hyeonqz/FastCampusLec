package org.example.api.domain.store.controller;

import org.example.api.common.api.Api;
import org.example.api.domain.store.business.StoreBusiness;
import org.example.api.domain.store.controller.model.StoreRegisterRequest;
import org.example.api.domain.store.controller.model.StoreResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/open-api/store")
@RestController
public class StoreOpenApiController {
	private final StoreBusiness storeBusiness;

	// 로그인 되지 않은 사람도 볼 수있는 API
	@PostMapping("/register")
	public Api<StoreResponse> register(@Valid @RequestBody Api<StoreRegisterRequest> request) {
		StoreResponse response = storeBusiness.register(request.getBody());
		return Api.OK(response);
	}
}
