package org.jedis.cache.domain.user.controller;

import org.jedis.cache.domain.user.entity.RedisHashUser;
import org.jedis.cache.domain.user.entity.User;
import org.jedis.cache.domain.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {
	private final UserService userService;

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@GetMapping("/redis-users/{id}")
	public RedisHashUser getHashUser(@PathVariable Long id) {
		return userService.getUser2(id);
	}
}
