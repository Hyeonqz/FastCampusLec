package org.example.db;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@SuperBuilder
public class BaseEntity {

	// 미리 아래 코드들을 정의해두면, 엔티티에 미리 정의 될 필요가 없다.
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreatedDate
	private LocalDateTime registeredAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

}
