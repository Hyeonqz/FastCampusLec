package org.example.api.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.jackson.ModelResolver;

@Configuration
public class SwaggerConfig {

	@Bean
	public ModelResolver modelResolver (ObjectMapper objectMapper) {
		// 이거는 그냥 메소드의 호출인데 그러면 아까 설정해준 objectMapper 는 누가 어떻게 호출을 해주나?
		// -> 스프링이 빈, 즉 아까 설정해둔 ObjectMapper 라는 Bean 을 자동으로 찾아서 넣어준다.
		// 현업에서는 보안 설정까지 하지만, 토이 프로젝트니 이정도만 하는걸로.
		return new ModelResolver(objectMapper);
	}
}
