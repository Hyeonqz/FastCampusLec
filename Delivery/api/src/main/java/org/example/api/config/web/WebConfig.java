package org.example.api.config.web;

import java.util.List;

import org.example.api.Interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
	// 인터셉터를 등록하기 위해선 config 설정 또한 해줘야한다.

	private final AuthorizationInterceptor authorizationInterceptor;

	private List<String> OPEN_API = List.of(
		"/open-api/**"
	);

	private List<String> DEFAULT_EXCLUDE = List.of(
		"/",
		"favicon.ico",
		"/error");

	private List<String> SWAGGER  = List.of(
		"/swagger-ui.html",
		"/swagger-ui/**",
		"/v3/api-docs/**"
	);

	// web 에 인터셉터를 등록하기
	@Override
	public void addInterceptors (InterceptorRegistry registry) {
		// 회원가입, 약관 동의 등등 인증을 태우면 안되는 API 들이 있다. 그런것 또한 처리
		registry.addInterceptor(authorizationInterceptor)
			// .excludePathPatterns("/api/users/register") 이런식으로 쭉 하면 엄청 많이 해야한다.
			// 그래서 규칙을 정해서 한다.
			.excludePathPatterns(OPEN_API) // OPEN_API 는 검증하지 않겠다는 뜻
			.excludePathPatterns(DEFAULT_EXCLUDE) // Default 는 검증하지 않겠다
			.excludePathPatterns(SWAGGER); // 스웨거는 검증하지 않겠다.
		// 나머지는 다 검증을 하겠다는 뜻.
	}

}
