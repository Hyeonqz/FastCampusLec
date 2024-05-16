package org.example.api.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMqConfig {

	// ROLE: exchange bean 으로 생성
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("delivery.exchange");
	}

	// ROLE: 메세지 발행 QUEUE 생성
	@Bean
	public Queue queue() {
		return new Queue("delivery.queue");
	}

	// 스프링에서 파라미터 값에 특별한 어노테이션 없어도 객체라면은
	// 빈 스코프 -> (어플리케이션 컨텍스트 안에서 그 객체를 찾아서 넣어준다)
	// ROLE: exchange 랑 queue 에 바인딩 될 수 있도록 설정
	@Bean
	public Binding binding(DirectExchange directExchange, Queue queue) {
		return BindingBuilder.bind(queue).to(directExchange).with("delivery.key");
	}

	// ROLE: Producer -> Exchange 로 데이터를 보낼 떄 설정, 프로토콜: http 로 고정
	@Bean
	public RabbitTemplate rabbitTemplate(
		ConnectionFactory connectionFactory,
		MessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate((connectionFactory));
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}

	// ROLE: object -> JSON -> Object 바꿔주는 역할
	@Bean
	public MessageConverter messageConverter(ObjectMapper objectMapper) {
		return new Jackson2JsonMessageConverter(objectMapper);
	}

	// Role: ConnectionFactory 관리는 application.yml 파일에서 함.

}
