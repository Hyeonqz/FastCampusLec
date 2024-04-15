package org.example.flow.service;

import java.time.Instant;
import org.example.flow.exception.ErrorCode;


import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class UserQueueService {
	private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
	private final String USER_QUEUE_WAIT_KEY = "users:queue:%s:wait";

	// 대기열 등록 API
	public Mono<Long> registerWaitQueue(final String queue, final Long userId) {
		// - redis sortedset 에 저장할 것이다.
		// - key : userID
		// - value : unix timestamp
		long unixTimestamp = Instant.now().getEpochSecond();

		return reactiveRedisTemplate.opsForZSet()
			.add(USER_QUEUE_WAIT_KEY.formatted(queue),userId.toString(), unixTimestamp)
			.filter(i -> i) // 잘 성공을 하면 flatMap 으로 ? 이미 등록이 된다면 에러를 처리.
			.switchIfEmpty(Mono.error(new Exception(ErrorCode.QUEUE_ALREADY_REGISTERED_USER.build())))
			.flatMap(i -> reactiveRedisTemplate.opsForZSet().rank(USER_QUEUE_WAIT_KEY.formatted(queue), userId.toString()))
			.map(i -> i>=0 ? i+1:i);
	}

}
