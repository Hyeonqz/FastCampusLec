package org.example.webflux.crud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostCreateRequest {
	private Long userId;
	private String title;
	private String content;
}
