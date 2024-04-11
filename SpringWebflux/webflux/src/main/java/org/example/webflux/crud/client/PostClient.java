package org.example.webflux.crud.client;

import org.example.webflux.crud.domain.dto.response.PostResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PostClient {
	private final WebClient webClient;
	private final String URL = "http://localhost:8090";

	// WebClient 사용해서 mvc 서버엣 ("/posts/{id}")
	public Mono<PostResponse> getPost(Long id) {
		String uriString = UriComponentsBuilder.fromHttpUrl(URL)
			.path("/posts/%d".formatted(id))
			.buildAndExpand()
			.toUriString();

		return webClient.get()
			.uri(uriString)
			.retrieve()
			.bodyToMono(PostResponse.class);
	}
}
