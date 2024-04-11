package org.example.webflux.crud.service;

import org.example.webflux.crud.domain.Post;
import org.example.webflux.crud.repository.PostR2dbcRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PostServiceV2 {
	private final PostR2dbcRepository postR2dbcRepository;

	// create -> 한개만 생성하기 때문에 Mono 를 사용한다.
	public Mono<Post> create(Long userId, String title, String content) {
		return postR2dbcRepository.save(Post.builder()
			.userId(userId)
			.title(title)
			.content(content)
			.build());
	}

	// read
	public Flux<Post> findAll() {
		return postR2dbcRepository.findAll();
	}

	public Mono<Post> findById(Long id) {
		return postR2dbcRepository.findById(id);
	}

	// delete
	public Mono<Void> deleteById (Long id) {
		return postR2dbcRepository.deleteById(id);
	}

	// update
}
