package org.example.api.domain.storemenu.controller;

import java.util.List;

import org.example.api.common.api.Api;
import org.example.api.domain.storemenu.business.StoreMenuBusiness;
import org.example.api.domain.storemenu.controller.model.StoreMenuRegisterRequest;
import org.example.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/open-api/store-menu")
@RequiredArgsConstructor
@RestController
public class StoreMenuOpenApiController {
	private final StoreMenuBusiness storeMenuBusiness;

	@PostMapping("/register")
	public Api<StoreMenuResponse> register(@Valid @RequestBody Api<StoreMenuRegisterRequest> request) {
		StoreMenuRegisterRequest req = request.getBody();
		StoreMenuResponse register = storeMenuBusiness.register(req);
		return Api.OK(register);
	}

}
