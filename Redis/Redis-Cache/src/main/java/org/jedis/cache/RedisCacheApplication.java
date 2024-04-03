package org.jedis.cache;

import org.jedis.cache.user.User;
import org.jedis.cache.user.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class RedisCacheApplication implements ApplicationRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepository.save(User.builder().name("arg").email("jin@naver.com").build());
		userRepository.save(User.builder().name("arg1").email("jin1@naver.com").build());
		userRepository.save(User.builder().name("arg2").email("jin2@naver.com").build());
		userRepository.save(User.builder().name("arg3").email("jin3@naver.com").build());



	}
}
