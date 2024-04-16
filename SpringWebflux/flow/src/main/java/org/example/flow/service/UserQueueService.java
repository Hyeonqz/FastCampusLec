package org.example.flow.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Queue;

import org.example.flow.exception.ErrorCode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserQueueService {
	private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
	private final String USER_QUEUE_WAIT_KEY = "users:queue:%s:wait";
	private final String USER_QUEUE_WAIT_KEY_FOR_SCAN = "users:queue:*:wait";
	private final String USER_QUEUE_PROCEED_KEY = "users:queue:%s:proceed";

/*	@Value("${scheduler.enabled")
	private Boolean scheduling = false;*/

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

	// 진입이 가능한 토큰인지 조회
	public Mono<Boolean> isAllowedToken(final String queue, final Long userId, final String token) throws
		NoSuchAlgorithmException {
		return this.generateToken(queue,userId)
			.filter(gen -> gen.equalsIgnoreCase(token))
			.map(i -> true)
			.defaultIfEmpty(false);
	}

	// 대기번호 체크
	public Mono<Long> getRank(final String queue, final Long userId) {
		return reactiveRedisTemplate.opsForZSet().rank(USER_QUEUE_WAIT_KEY.formatted(queue), userId.toString())
			.defaultIfEmpty(-1L)
			.map(rank -> rank >= 0 ? rank+1 : rank); // 0부터 아닌 첫번째 대기자 부터 하기 위해 +1 을 해줌
	}

	// Token 전달
	public Mono<String> generateToken(final String queue, final Long userId) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		var input = "user-queue-%s-%d".formatted(queue,userId);
		byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

		StringBuilder sb = new StringBuilder();
		for (byte abyte : encodedHash) {
			sb.append(String.format("%02X",abyte));
		}
		return Mono.just(sb.toString());
	}

	@Scheduled(initialDelay = 5000, fixedDelay = 10000) // 서버가 시작하고 5초뒤 시작하고, 그 뒤로는 3초 주기로 설정해줘
	public void scheduleAllowUser() {
/*		if (!scheduling) {
			log.info("passed scheduling...");
			return;
		}*/
		log.info("called scheduling...");

		var maxAllowUserCount = 3L;

		// 사용자 허용하는 로직 작성
		reactiveRedisTemplate.scan(ScanOptions.scanOptions().
			match(USER_QUEUE_WAIT_KEY_FOR_SCAN)
			.count(100)
			.build())
			.map(key -> key.split(":")[2])
			.flatMap(queue -> allowUser(queue, maxAllowUserCount).map(allowed -> Tuples.of(queue,allowed))) // 3명을 주기적으로 허용하겠다.
			.doOnNext(tuple -> log.info("Tried %d and allowed %d members of %s queue".formatted(maxAllowUserCount,tuple.getT2(),tuple.getT1())))
			.subscribe();
	}


}
