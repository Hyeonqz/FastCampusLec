package com.delivery.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.delivery.db")
@EnableJpaRepositories(basePackages = "com.delivery.db")
public class JpaConfig {

    // 모듈이 다르고, 패키지가 다르기 때문에 Bean 등록이 안되는 오류를 해결하기 위한 설정


}
