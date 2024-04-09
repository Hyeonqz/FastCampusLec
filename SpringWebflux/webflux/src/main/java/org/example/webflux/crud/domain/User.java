package org.example.webflux.crud.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private Long id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
