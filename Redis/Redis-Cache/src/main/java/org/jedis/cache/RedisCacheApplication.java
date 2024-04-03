package org.jedis.cache;

import org.jedis.cache.domain.user.entity.User;
import org.jedis.cache.domain.user.repository.UserRepository;
import org.jedis.cache.domain.user1.User1Repository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.RequiredArgsConstructor;

@EnableJpaAuditing
@RequiredArgsConstructor
@SpringBootApplication
public class RedisCacheApplication implements ApplicationRunner {

	private final User1Repository user1Repository;
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
/*		userRepository.save(User.builder().name("arg").email("jin@naver.com").build());
		userRepository.save(User.builder().name("arg1").email("jin1@naver.com").build());
		userRepository.save(User.builder().name("arg2").email("jin2@naver.com").build());
		userRepository.save(User.builder().name("arg3").email("jin3@naver.com").build());*/
	}
}
