package org.delivery.storeadmin.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "org.example.db")
@EntityScan(basePackages = "org.example.db")
@Configuration
public class JpaConfig {

}
