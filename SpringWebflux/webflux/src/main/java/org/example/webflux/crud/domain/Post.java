package org.example.webflux.crud.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("posts")
public class Post {

	@Id
	private Long id;

	@Column("user_id")
	private Long userId;

	private String title;
	private String content;

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
