package org.example.webflux.crud.domain.dto.response;

import java.time.LocalDateTime;

import org.example.webflux.crud.domain.Post;
import org.example.webflux.crud.service.PostServiceV2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostResponseV2 {
	private Long id;
	private Long userId;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	// 엔티티 객체를 직접 받지않고, 변환을 해서 받기 위한 메소드 이다. 즉 엔티티를 받아서 dto 로 반환한다.
	public static PostResponseV2 of(Post post) {
		return PostResponseV2.builder()
			.id(post.getId())
			.userId(post.getUserId())
			.content(post.getContent())
			.createdAt(post.getCreatedAt())
			.updatedAt(post.getUpdatedAt())
			.build();
	}
}
