package org.example.api.domain.user.controller.model.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

	// 회원가입 시 요청알 필수 정보들 => @NotBlank
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String address;
	@NotBlank
	private String password;
}
