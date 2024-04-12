package org.example.webflux.config;

import java.time.Duration;

import org.example.webflux.crud.domain.entity.User;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class RedisConfig implements ApplicationListener<ApplicationReadyEvent> {
	private final ReactiveRedisTemplate<String, String> redisTemplate;

	@Override
	public void onApplicationEvent (ApplicationReadyEvent event) {
		redisTemplate.opsForValue().get("1")
			.doOnSuccess(i -> log.info("Initialize Redis connection"))
			.doOnError( (err) -> log.error("failed redis connection : {} ", err.getMessage()) )
			.subscribe();

		redisTemplate.opsForList().leftPush("list1","hello").subscribe();
		redisTemplate.opsForValue().set("sampleKey1","sample", Duration.ofSeconds(60)).subscribe();
	}

	@Bean
	public ReactiveRedisTemplate<String, User> reactiveRedisTemplate(ReactiveRedisConnectionFactory connectionFactory) {
		var objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.registerModule(new JavaTimeModule())
			.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

		Jackson2JsonRedisSerializer<User> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(objectMapper, User.class);

		RedisSerializationContext<String, User> serializationContext = RedisSerializationContext
			.<String, User>newSerializationContext()
			.key(RedisSerializer.string())
			.value(jsonRedisSerializer)
			.hashKey(RedisSerializer.string())
			.hashValue(jsonRedisSerializer)
			.build();

		return new ReactiveRedisTemplate<>(connectionFactory,serializationContext);
	}

}
