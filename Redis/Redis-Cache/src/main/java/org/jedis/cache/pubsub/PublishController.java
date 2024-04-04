package org.jedis.cache.pubsub;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PublishController {

	private final RedisTemplate<String,String> redisTemplate;

	@PostMapping("/event/users/deregister")
	void publishUserDeregisterEvent() {
		redisTemplate.convertAndSend("users:unregister","500");
	}

}
