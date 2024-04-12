package org.example.webflux.crud.service;

import org.example.webflux.crud.domain.entity.User;
import org.example.webflux.crud.repository.UserR2dbcRepository;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class UserService {
	// private final UserRepositoryImpl userRepository;
	private final UserR2dbcRepository userR2dbcRepository;

	private final ReactiveRedisTemplate<String, User> reactiveRedisTemplate;

	// create
	public Mono<User> create(String name, String email) {
		return userR2dbcRepository.save(User.builder()
			.name(name)
			.email(email)
			.build());
	}

	private String getUserCacheKey(Long id) {
		return "users:%d".formatted(id);
	}

	public Mono<User> findById(Long id) {
		return reactiveRedisTemplate.opsForValue()
			.get("users:%d".formatted(id))
			.switchIfEmpty(userR2dbcRepository.findById(id))
			.flatMap(u -> reactiveRedisTemplate.opsForValue().set(getUserCacheKey(id),u)
			.then(Mono.just(u))
			);
	}

	// update
	public Mono<User> update(Long id, String name, String email) {
		// 1번 : 해당 사용자를 찾는다.
		// 2번 : 데이터를 변경하고 저장한다.
		return userR2dbcRepository.findById(id)
			.flatMap( u-> {
				u.setName(name);
				u.setEmail(email);
				return userR2dbcRepository.save(u);
			});
	}

	// delete
	public Mono<Void> deleteById(Long id) {
		return userR2dbcRepository.deleteById(id);
	}

	public Mono<Void> deleteByName(String name) {
		return userR2dbcRepository.deleteByName(name);
	}

	// read
	public Flux<User> findAll() {
		return userR2dbcRepository.findAll();
	}

/*	public Mono<User> findById(Long id) {
		return userR2dbcRepository.findById(id);
	}*/
}
