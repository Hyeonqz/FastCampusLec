package org.jedis.cache.domain.user.service;

import java.time.Duration;

import org.jedis.cache.domain.user.entity.RedisHashUser;
import org.jedis.cache.domain.user.entity.User;
import org.jedis.cache.domain.user.repository.RedisHashUserRepository;
import org.jedis.cache.domain.user.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final RedisHashUserRepository hashUserRepository;
	private final RedisTemplate<String, User> redisTemplate;
	private final RedisTemplate<String, Object> objectRedisTemplate;

	public User getUser(final Long id) {
		var key = "users:%d".formatted(id);

		// 1. cache get
		var cached = redisTemplate.opsForValue().get(key);
		if(cached != null) {
			return cached;
		}
		// 2. else db -> cache set
		else {
			User user = userRepository.findById(id).orElseThrow();
			redisTemplate.opsForValue().set(key,user, Duration.ofSeconds(30));
			return user;
		}
	}

	public RedisHashUser getUser2(final Long id) {
		// redis 값이 잇으면 리턴
		var cachedUser = hashUserRepository.findById(id).orElseGet( () -> {
			User user = userRepository.findById(id).orElseThrow();
			return hashUserRepository.save(RedisHashUser.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.createdAt(user.getCreatedAt())
				.updatedAt(user.getUpdatedAt())
				.build());
		});
		return cachedUser;
		// 없으면 DB 값을 활용합니다.
	}

	@Cacheable(cacheNames = "CACHE1", key="'user:' + #id")
	public User getUser3(final Long id) {
		return userRepository.findById(id).orElseThrow();
	}


}
