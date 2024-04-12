package org.example.webflux.crud.controller;

import org.example.webflux.crud.domain.dto.request.UserCreateRequest;
import org.example.webflux.crud.domain.dto.request.UserUpdateRequest;
import org.example.webflux.crud.domain.dto.response.UserPostResponse;
import org.example.webflux.crud.domain.dto.response.UserResponse;
import org.example.webflux.crud.service.PostServiceV2;
import org.example.webflux.crud.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {
	private final UserService userService;
	private final PostServiceV2 postServiceV2;

	//crud
	@PostMapping("/create")
	public Mono<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
		return userService.create(userCreateRequest.getName(), userCreateRequest.getEmail())
			.map(UserResponse::of);
	}

	@GetMapping("")
	public Flux<UserResponse> findAllUsers() {
		return userService.findAll()
			.map(UserResponse::of);
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<UserResponse>> findUser(@PathVariable Long id) {
		return userService.findById(id)
			.map( u -> ResponseEntity.ok(UserResponse.of(u)))
			.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

	@DeleteMapping("/del/{id}")
	public Mono<ResponseEntity<?>> deleteUser(@PathVariable Long id) {
		// 204(no content)
		return userService.deleteById(id)
			.then(Mono.just(ResponseEntity.noContent().build()));
	}

	@PutMapping("/update/{id}")
	public Mono<ResponseEntity<UserResponse>> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest) {
		// user (x) : 404 not found
		// user (o) : 200 ok
		return userService.update(id, userUpdateRequest.getName(), userUpdateRequest.getEmail())
			.map( u -> ResponseEntity.ok(UserResponse.of(u)))
			.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

	@DeleteMapping("/search")
	public Mono<ResponseEntity<?>> deleteUser(@RequestParam String name) {
		return userService.deleteByName(name).then(Mono.just(ResponseEntity.noContent().build()));
	}

	@GetMapping("/{id}/posts")
	public Flux<UserPostResponse> getUserPosts(@PathVariable Long id) {
		return postServiceV2.findAllByUserId(id)
			.map(UserPostResponse::of);
	}
}
