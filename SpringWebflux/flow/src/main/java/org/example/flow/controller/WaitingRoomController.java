package org.example.flow.controller;

import org.example.flow.service.UserQueueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.result.view.Rendering;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Controller
public class WaitingRoomController {
	private final UserQueueService userQueueService;

	@GetMapping("/waiting-room")
	public Mono<Rendering> waitingRoomPage(
		@RequestParam(name="queue", defaultValue = "default") String queue,
		@RequestParam(name="user_id", defaultValue = "default") Long userId,
		@RequestParam(name="redirect_url") String redirectUrl) {

		// 대기 등록, 즉 웹페에지 필요한 데이터를 전달하는 로직
		// 1. 입장이 허용되어 page redirect(이동)이 가능한 상태인가?
		// 2. 어디로 이동해야 하는가?
		return userQueueService.isAllowed(queue,userId) // 허용 가능한 상태인지.
			.filter(allowed -> allowed)
			.flatMap(allowed -> Mono.just(Rendering.redirectTo(redirectUrl).build()))
			.switchIfEmpty(userQueueService.registerWaitQueue(queue,userId)
				.onErrorResume(ex -> userQueueService.getRank(queue,userId)) // 이미 등록되있는 경우는, 값들을 알아낸다
				.map(rank -> Rendering.view("waiting-room.html")
					.modelAttribute("number", rank)
					.modelAttribute("userId",userId)
					.modelAttribute("queue",queue)
					.build()
				)
			);
	}

}
