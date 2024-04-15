package org.example.flow.service;

import static org.junit.jupiter.api.Assertions.*;

import org.example.flow.EmbeddedRedis;
import org.example.flow.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.ReactiveRedisConnection;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.test.context.ActiveProfiles;

import reactor.test.StepVerifier;

@SpringBootTest
@ActiveProfiles("test")
@Import(EmbeddedRedis.class) // 포함 시켜서 진행 하겠다는 뜻.
class UserQueueServiceTest {
	@Autowired
	private UserQueueService userQueueService;

	@Autowired
	private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

	@BeforeEach
	public void beforeEach() {
		ReactiveRedisConnection reactiveRedisConnection = reactiveRedisTemplate.getConnectionFactory().getReactiveConnection();
		reactiveRedisConnection.serverCommands().flushAll().subscribe();
	}

	@Test
	void registerWaitQueue() {
		// given
		StepVerifier.create(userQueueService.registerWaitQueue("default", 100L))
			.expectNext(1L)
			.verifyComplete();

		StepVerifier.create(userQueueService.registerWaitQueue("default", 101L))
			.expectNext(2L)
			.verifyComplete();


	}

	@Test
	void alreadyRegisterWaitQueue() {
		StepVerifier.create(userQueueService.registerWaitQueue("default", 100L))
			.expectNext(1L)
			.verifyComplete();

		StepVerifier.create(userQueueService.registerWaitQueue("default", 100L))
			.expectError(ApplicationException.class)
			.verify();
	}

	@Test
	void emptyAllowUser () {
		StepVerifier.create(userQueueService.allowUser("default",3L))
			.expectNext(0L)
			.verifyComplete();
	}

	@Test
	void isAllowed () {
		StepVerifier.create(userQueueService.registerWaitQueue("default",100L)
			.then(userQueueService.registerWaitQueue("default",101L))
			.then(userQueueService.registerWaitQueue("default",102L))
			.then(userQueueService.allowUser("default",2L)))
			.expectNext(2L)
			.verifyComplete();
	}

	@Test
	void isAllowed2 () {
		StepVerifier.create(userQueueService.registerWaitQueue("default",100L)
				.then(userQueueService.registerWaitQueue("default",101L))
				.then(userQueueService.registerWaitQueue("default",102L))
				.then(userQueueService.allowUser("default",2L)))
			.expectNext(3L)
			.verifyComplete();
	}

}