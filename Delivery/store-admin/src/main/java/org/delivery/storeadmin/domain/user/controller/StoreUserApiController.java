package org.delivery.storeadmin.domain.user.controller;

import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.delivery.storeadmin.domain.user.converter.StoreUserConverter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/store-user")
@RestController
public class StoreUserApiController {
	private final StoreUserConverter storeUserConverter;

	@GetMapping("/me")
	public StoreUserResponse me(
		@Parameter(hidden = true)
		@AuthenticationPrincipal UserSession userSession // UserDetail 을 상속받은 객체를 주입해준다
	) {
		return storeUserConverter.toResponse(userSession);
	}
}
