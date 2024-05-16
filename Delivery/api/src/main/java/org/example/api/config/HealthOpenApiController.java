package org.example.api.config;

import org.example.api.common.rabbitmq.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/open-api")
@RequiredArgsConstructor
@RestController
public class HealthOpenApiController {
	private final Producer producer;

	@GetMapping("/health")
	public void health() {
		log.info("health call");
		producer.producer("delivery.exchange","delivery.key","hello");
	}
}
