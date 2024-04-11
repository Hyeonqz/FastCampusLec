package org.example.webflux.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class SampleController {

	@GetMapping("/sample/hello")
	public Mono<String> getHello() {
		// reactor
		// publisher <---> subscriber
		return Mono.just("hello rest controller with webflux");
	}
}
