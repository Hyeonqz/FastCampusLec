package org.example.webflux.crud.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.example.webflux.crud.domain.entity.User;
import org.example.webflux.crud.domain.dto.request.UserCreateRequest;
import org.example.webflux.crud.domain.dto.response.UserResponse;
import org.example.webflux.crud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest(UserController.class)
@AutoConfigureWebTestClient
class UserControllerTest {
	@Autowired
	private WebTestClient webTestClient;

	@MockBean // 가짜 Bean 을 만드는 것
	private UserService userService;

	@Test
	void createUser () {
		when(userService.create("jin", "jin@naver.com")).thenReturn(
			Mono.just(new User(1L,"jin","jin@naver.com", LocalDateTime.now(), LocalDateTime.now()))
		);

		webTestClient.post().uri("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.bodyValue(new UserCreateRequest("jin","jin@naver.com"))
			.exchange()
			.expectStatus().is2xxSuccessful()
			.expectBody(UserResponse.class)
			.value(res -> {
				assertEquals("jin", res.getName());
				assertEquals("jin@naver.com", res.getEmail());
			});
	}

	@Test
	void findAllUsers () {

		when(userService.findAll()).thenReturn(
			Flux.just(
				new User(1L,"jin","jin@naver.com", LocalDateTime.now(), LocalDateTime.now()),
				new User(1L,"jin","jin@naver.com", LocalDateTime.now(), LocalDateTime.now()),
				new User(1L,"jin","jin@naver.com", LocalDateTime.now(), LocalDateTime.now())
				));

		webTestClient.get().uri("/users")
			.exchange()
			.expectStatus().is2xxSuccessful()
			.expectBodyList(UserResponse.class)
			.hasSize(3);
	}

	@Test
	void findUser () {

	}

	@Test
	void deleteUser () {

	}

	@Test
	void updateUser () {

	}

}