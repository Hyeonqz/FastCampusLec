package org.example.webflux.crud.repository;

import org.example.webflux.crud.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserR2dbcRepository extends ReactiveCrudRepository<User,Long> {
}
