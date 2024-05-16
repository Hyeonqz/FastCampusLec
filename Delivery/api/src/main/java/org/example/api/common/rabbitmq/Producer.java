package org.example.api.common.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Producer {
	private final RabbitTemplate rabbitTemplate;

	// Role: Producer 에서 이벤트를 어디로 발생시킬지 로직
	public void producer(String exchange, String routingKey, Object data) {
		rabbitTemplate.convertAndSend(exchange, routingKey, data);
	}
}
