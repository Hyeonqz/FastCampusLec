package org.example.webflux.crud.domain.dto.response;

import java.time.LocalDateTime;

import org.example.webflux.crud.domain.entity.Post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPostResponse {
	private Long id;
	private String username;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public static UserPostResponse of(Post post) {
		return UserPostResponse.builder()
			.id(post.getId())
			.username("TODO")
			.title(post.getTitle())
			.content(post.getContent())
			.createdAt(post.getCreatedAt())
			.updatedAt(post.getUpdatedAt())
			.build();
	}

}
