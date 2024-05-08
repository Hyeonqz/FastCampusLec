package org.delivery.storeadmin.config.security;

import java.util.List;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // security 활성화
@Configuration
public class SecurityConfig {

	// 스웨거 주소 리스트로 담아서 시큐리티에 넣기
	private List<String> SWAGGER = List.of(
		"/swagger-ui.html",
		"/swagger-ui/**",
		"/v3/api-docs/**"
	);

	// 예전에는 상속받아서 설정 하였음
	// 이제는 Bean 으로 등록을 해서 사용할 수 있다.
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf((csrf) -> csrf. disable())
			.authorizeHttpRequests(it -> { // 요청 설정
				it.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
					.permitAll() // static Resource 에 대해서는 모든 요청 허가

					// swagger 는 인증 없이 통과
					.requestMatchers(
						SWAGGER.toArray(new String[0])
					)
					.permitAll()

					// open-api 하위 모든 주소는 인증 없이 허용하겠다는 설정
					.requestMatchers(
						"/open-api/**"
					)
					.permitAll()

					// 이 외에 모든 요청은 인증을 통과해야 한다.
					.anyRequest().authenticated();
			})
			.formLogin(Customizer.withDefaults()); // 폼 로그인은 디폴트로 나오게한다.

		return httpSecurity.build();
	}

	// 스프링 시큐리티는 BCrypt 를 사용한다.
	// 패스워드 Bean 으로 등록시키기
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Hash 방식으로 암호화를 하며, sort 까지해서 정렬까지 한 후 hash 로 저장을 함
		// 디코딩은 불가능, 인코딩만 가능하다.
		return new BCryptPasswordEncoder();
	}

}
