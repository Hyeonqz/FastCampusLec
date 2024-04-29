package org.example.api.domain.user.controller.model.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserLoginRequest {

	@NotBlank
	private String email;

	@NotBlank
	private String password;
}
