package org.example.webflux.crud.controller;

import org.example.webflux.crud.domain.dto.request.PostCreateRequest;
import org.example.webflux.crud.domain.dto.response.PostResponseV2;
import org.example.webflux.crud.service.PostServiceV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/v2/posts")
@RestController
public class PostControllerV2 {
	private final PostServiceV2 postServiceV2;

	@PostMapping("")
	public Mono<PostResponseV2> createPost(@RequestBody PostCreateRequest request) {
		return postServiceV2.create(request.getUserId(), request.getTitle(), request.getContent())
			.map(PostResponseV2::of);
	}

	@GetMapping("")
	public Flux<PostResponseV2> findAllPost () {
		return postServiceV2.findAll()
			.map(PostResponseV2::of);
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<PostResponseV2>> findPost(@PathVariable Long id) {
		return postServiceV2.findById(id)
			.map(p -> ResponseEntity.ok().body(PostResponseV2.of(p)))
			.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<PostResponseV2>> deletePost(@PathVariable Long id) {
		return postServiceV2.deleteById(id).then(Mono.just(ResponseEntity.noContent().build()));
	}

}
