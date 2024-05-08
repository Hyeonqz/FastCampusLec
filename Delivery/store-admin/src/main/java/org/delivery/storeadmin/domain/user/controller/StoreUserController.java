package org.delivery.storeadmin.domain.user.controller;

import org.delivery.storeadmin.domain.user.business.StoreUserBusiness;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/open-api/store-user")
@RestController
public class StoreUserController {
	private final StoreUserBusiness storeUserBusiness;

	@PostMapping("/")
	public ResponseEntity<StoreUserResponse> register (
		@Valid @RequestBody StoreUserRegisterRequest storeUserRegisterRequest) {
		StoreUserResponse register = storeUserBusiness.register(storeUserRegisterRequest);
		return ResponseEntity.ok(register);
	}
}
