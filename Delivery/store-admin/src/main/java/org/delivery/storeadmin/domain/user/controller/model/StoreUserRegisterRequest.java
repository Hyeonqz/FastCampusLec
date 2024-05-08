package org.delivery.storeadmin.domain.user.controller.model;

import org.example.db.storeuser.enums.StoreUserRole;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StoreUserRegisterRequest {
	@NotBlank
	private String storeName;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private StoreUserRole role;
}
