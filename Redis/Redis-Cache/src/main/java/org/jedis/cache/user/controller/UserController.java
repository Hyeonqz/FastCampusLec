package org.jedis.cache.user.controller;

import java.util.Optional;

import org.jedis.cache.user.User;
import org.jedis.cache.user.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RequiredArgsConstructor
@RestController
public class UserController {
	private final UserRepository userRepository;
	private final JedisPool jedisPool;


	@GetMapping("/users/{id}/email")
	public String getUserEmail(@PathVariable Long id) {

		try (Jedis jedis = jedisPool.getResource()) {
			var userEmailRedisKey = "users:%d:email".formatted(id);
			// 1. request to cache
			String useEmail = jedis.get(userEmailRedisKey);

			if(useEmail != null) {
				return useEmail;
			}
			// 2. else db
			else {
				useEmail = userRepository.findById(id).orElse(User.builder().build()).getEmail();
			}
			// 3. cache
			jedis.set(userEmailRedisKey, useEmail);
			jedis.setex(userEmailRedisKey,30,useEmail);
			// 4. end
			return useEmail;
		}
	}

}
