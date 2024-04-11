package org.example.webflux.crud.repository;

import org.example.webflux.crud.domain.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PostR2dbcRepository extends ReactiveCrudRepository<Post, Long> {



}
