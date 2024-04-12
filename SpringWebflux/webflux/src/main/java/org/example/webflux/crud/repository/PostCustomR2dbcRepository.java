package org.example.webflux.crud.repository;

import org.example.webflux.crud.domain.entity.Post;

import reactor.core.publisher.Flux;

public interface PostCustomR2dbcRepository {

	Flux<Post> findByUserId(Long userId);

}