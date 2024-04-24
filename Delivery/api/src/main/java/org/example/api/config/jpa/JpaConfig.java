package org.example.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "org.example.db") // Entity 가 존재하는 경로를 알려주고 스캔한다.
@EnableJpaRepositories(basePackages = "org.example.db") // Repository 가 존재하는 경로를 알려주고 사용할 수 있게 만든다.
@Configuration
public class JpaConfig {
	// 멀티 모듈로 진행할 경우 이런 세부적인 설정이 필요하다.
	// db(org.example.db) 모듈에 있는 클래스들을 Bean 으로 동작해준다.
	// 이렇게 해야지 api 모듈에서 db 모듈을 자유자재로 사용할 수 있기 때문이다.

}
