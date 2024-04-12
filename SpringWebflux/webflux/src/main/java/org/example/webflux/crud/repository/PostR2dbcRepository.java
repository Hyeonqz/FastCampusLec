package org.example.webflux.crud.repository;

import org.example.webflux.crud.domain.entity.Post;
import org.example.webflux.crud.domain.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface PostR2dbcRepository extends ReactiveCrudRepository<Post, Long> {

	Flux<Post> findByUserId(Long id);

}
