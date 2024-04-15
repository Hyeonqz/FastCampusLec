package org.example.flow.service;

import java.time.Instant;
import java.util.Queue;

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
	private final String USER_QUEUE_PROCEED_KEY = "users:queue:%s:proceed";

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

	// 진입이 가능한 상태인지 조회
	// 진입을 허용
	public Mono<Long> allowUser(final String queue, final Long count) {
		// 진입 허용 단계
		// 1. wait queue 사용 제거
		// 2. proceed queue 사용자를 추가
		return reactiveRedisTemplate.opsForZSet().
			popMin(USER_QUEUE_WAIT_KEY.formatted(queue),count) // value 값 중 작은 값을  뺸다
			.flatMap(member -> reactiveRedisTemplate.opsForZSet().add(USER_QUEUE_PROCEED_KEY.formatted(queue), member.getValue(), Instant.now().getEpochSecond()))
			.count();
	}

	// 진입이 가능한 상태인지 조회
	public Mono<Boolean> isAllowed(final String queue, final Long userId) {
		return reactiveRedisTemplate.opsForZSet().rank(USER_QUEUE_PROCEED_KEY.formatted(queue), userId.toString())
			.defaultIfEmpty(-1L)
			.map(rank -> rank >=0);
	}



}
