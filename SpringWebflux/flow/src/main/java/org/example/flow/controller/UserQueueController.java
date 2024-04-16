package org.example.flow.controller;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import org.example.flow.dto.AllowUserResponse;
import org.example.flow.dto.AllowedUserResponse;
import org.example.flow.dto.RankNumberResponse;
import org.example.flow.dto.RegisterUserResponse;
import org.example.flow.service.UserQueueService;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/api/v1/queue")
@RestController
public class UserQueueController {
	private final UserQueueService userQueueService;
	// 등록 할 수 있는 API path
	@PostMapping()
	public Mono<RegisterUserResponse> registerUser(@RequestParam(name="queue", defaultValue = "default") String queue,
													@RequestParam(name="user_id") Long userId) {
		return userQueueService.registerWaitQueue(queue,userId)
			.map(RegisterUserResponse ::new); // 인스턴스는 생성하지 않고, 객체만 생성해서 map 으로 변환한다.
	}

	@PostMapping("/allow")
	public Mono<?> allowUser(@RequestParam(name="queue", defaultValue = "default") String queue,
							@RequestParam(name="count") Long count)
	{
		return userQueueService.allowUser(queue,count)
			.map(allowed -> new AllowUserResponse(count,allowed));
	}

	@GetMapping("/allowed")
	public Mono<AllowedUserResponse> isAllowedUser(@RequestParam(name="queue", defaultValue = "default") String queue,
								@RequestParam(name="user_id") Long userId) {
		return userQueueService.isAllowed(queue, userId)
			.map(AllowedUserResponse::new);
	}

	@GetMapping("/rank")
	public Mono<RankNumberResponse> getRankUser(
		@RequestParam(name="queue", defaultValue = "default") String queue,
		@RequestParam(name="user_id") Long userId
	) {
		return userQueueService.getRank(queue,userId)
			.map(RankNumberResponse::new);
	}

	@GetMapping("/touch")
	public Mono<?> touch(
		@RequestParam(name="queue", defaultValue = "default") String queue,
		@RequestParam(name="user_id") Long userId,
		ServerWebExchange serverWebExchange
	) throws NoSuchAlgorithmException {
		return userQueueService.generateToken(queue,userId)
			.map(token -> {
				serverWebExchange.getResponse().addCookie(
					ResponseCookie
						.from("user-queue-%s-token".formatted(queue),token)
						.maxAge(Duration.ofSeconds(300))
						.path("/")
					.build()
			);
		return token;
		});

	}

}
