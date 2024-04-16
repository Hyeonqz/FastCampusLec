package org.example.flow;

import java.io.IOException;

import org.springframework.boot.test.context.TestConfiguration;

import jakarta.annotation.PostConstruct;
import redis.embedded.RedisServer;

@TestConfiguration
public class EmbeddedRedis {
	private final RedisServer redisServer;

	public EmbeddedRedis() throws IOException {
		this.redisServer = new RedisServer(63790);
	}

	// Embedded Redis server 시작
	@PostConstruct
	public void start() throws IOException {
		this.redisServer.start();
	}

	// Embedded Redis server 종료
	public void stop() throws IOException {
		this.redisServer.stop();
	}


}
