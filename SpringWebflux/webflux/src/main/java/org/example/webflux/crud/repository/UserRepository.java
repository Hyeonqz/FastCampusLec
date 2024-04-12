package org.example.webflux.crud.repository;

import org.example.webflux.crud.domain.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
	// CRUD
	Mono<User> save(User user);

	Flux<User> findAll();

	Mono<User> findById(Long id);

	Mono<Integer> deleteById(Long id);
}
