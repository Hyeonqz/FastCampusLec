package org.example.webflux.crud.service;

import java.util.List;

import org.example.webflux.crud.client.PostClient;
import org.example.webflux.crud.domain.dto.response.PostResponse;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@Service
public class PostService {

	// webclient mvc server 요청하기.
	private final PostClient postClient;

	public Mono<PostResponse> getPostContent(Long id) {
		return postClient.getPost(id)
			.onErrorResume(error -> Mono.just(new PostResponse(id.toString(), "Fall Back data".formatted(id))));
			// 데이터가 실패하면 위 메세지를 보낸다. 실패해도 오류가 나지 않는다 일단
	}

	public Flux<PostResponse> getMultiplePostContent(List<Long> idList) {
		return Flux.fromIterable(idList)
			.flatMap(this::getPostContent)
			.log();
	}

	public Flux<PostResponse> getParallelPostContent(List<Long> idList) {
		return Flux.fromIterable(idList)
			.parallel()
			.runOn(Schedulers.parallel())
			.flatMap(this::getPostContent)
			.log()
			.sequential();
	}


}
