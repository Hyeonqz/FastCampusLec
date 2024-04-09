package org.example.webflux.crud.service;

import org.example.webflux.crud.domain.User;
import org.example.webflux.crud.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepositoryImpl userRepository;

	// create
	public Mono<User> create(String name, String email) {
		return userRepository.save(User.builder()
			.name(name)
			.email(email)
			.build());
	}

	// update
	public Mono<User> update(Long id, String name, String email) {
		// 1번 : 해당 사용자를 찾는다.
		// 2번 : 데이터를 변경하고 저장한다.
		return userRepository.findById(id)
			.flatMap( u-> {
				u.setName(name);
				u.setEmail(email);
				return userRepository.save(u);
			});
	}

	// delete
	public Mono<Integer> deleteById(Long id) {
		return userRepository.delete(id);
	}

	// read
	public Flux<User> findAll() {
		return userRepository.findAll();
	}

	public Mono<User> findById(Long id) {
		return userRepository.findById(id);
	}
}
