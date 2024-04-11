package org.example.webflux.crud.controller;

import java.util.List;

import org.example.webflux.crud.domain.dto.response.PostResponse;
import org.example.webflux.crud.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/posts")
@RequiredArgsConstructor
@RestController
public class PostController {
	private final PostService postService;

	@GetMapping("/{id}")
	public Mono<PostResponse> getPostContent(@PathVariable Long id) {
		return postService.getPostContent(id);
	}

	@GetMapping("/search")
	public Flux<PostResponse> getMultiplePostContent(
		@RequestParam(name="ids")List<Long> idList
	) {
		return postService.getParallelPostContent(idList);
	}
}
