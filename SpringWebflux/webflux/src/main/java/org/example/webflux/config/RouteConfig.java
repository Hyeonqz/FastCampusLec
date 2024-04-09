package org.example.webflux.config;

import org.example.webflux.SampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class RouteConfig {
	private final SampleHandler sampleHandler;

	@Bean
	public RouterFunction<ServerResponse> route() {
		return RouterFunctions.route()
			.GET("/hello-functional", sampleHandler::getString)
			.build();
	}


}
