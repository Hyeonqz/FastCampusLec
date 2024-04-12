package org.example.webflux.crud.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class User {

	@Id
	private Long id;

	private String name;

	private String email;

	@CreatedDate // 자동으로 입력이 되게 해주는 어노테이션 -> + Config 설정또한 추가 해줘야지 가능 @EnableR2dbcAuditing
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
}
