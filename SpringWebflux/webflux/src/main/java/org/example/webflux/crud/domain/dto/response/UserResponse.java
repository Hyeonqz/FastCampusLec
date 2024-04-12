package org.example.webflux.crud.domain.dto.response;

import java.time.LocalDateTime;

import org.example.webflux.crud.domain.entity.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
	private Long id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public static UserResponse of(User user) {
		return UserResponse.builder()
			.id(user.getId())
			.name(user.getName())
			.email(user.getEmail())
			.createdAt(user.getCreatedAt())
			.updatedAt(user.getUpdatedAt())
			.build();
	}
}
