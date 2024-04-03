package org.jedis.cache.user;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) //테이블 필드가 생성될 떄 자동으로 값이 들어간다. 필드가 갱신되면 같이 갱신이 됩니다.
@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String email;

	@Column(length = 30)
	private String name;

	@CreatedDate
	@Column(name="created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

}
