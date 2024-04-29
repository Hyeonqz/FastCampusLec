package org.example.api.account.controller;

import java.time.LocalDateTime;

import org.example.api.account.model.response.AccountMeResponse;
import org.example.api.common.api.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountApiController {

	// 스프링은 자기 자신과 동일한 경로에 있는 패키지에 있는 Bean 을 자신의 Bean 으로 등록한다.
	// private final AccountRepository accountRepository;
	// 그러므로 위 코드는 다른 모듈에 다른 패키지에 있기 때문에 Bean 이 type 을 찾을 수 없습니다.
	// 이럴 경우
	// 1) 패키지 명을 모듈 다 똑같이 맞춘다 ? -> 별로임
	// 2) 아니면 다른 모듈에 있는 내가 쓰고싶은 클래스들을 Bean 으로 고려되게 등록을 해줘야 한다.
	// -> 이럴떈 2번 방법으로 Config 를 추가해서 진행하는게 좋다.

	@GetMapping("/me")
	public Api<AccountMeResponse> me () {
		AccountMeResponse response = AccountMeResponse.builder()
			.name("진현규")
			.email("jin@naver.com")
			.registeredAt(LocalDateTime.now())
			.build();

		return Api.OK(response);
	}


}
