package org.delivery.storeadmin.domain.user.controller.model;

import java.time.LocalDateTime;

import org.example.db.storeuser.enums.StoreUserRole;
import org.example.db.storeuser.enums.StoreUserStatus;
import org.example.db.user.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class StoreUserResponse {

	private UserReponse user;
	private StoreResponse store;

	@Builder
	@Value
	public static class UserReponse {
		Long id;
		String email;
		StoreUserStatus status;
		StoreUserRole role;
		LocalDateTime registeredAt;
		LocalDateTime unregisteredAt;
		LocalDateTime lastLoginAt;
	}


	@Builder
	@Value
	public static class StoreResponse {
		Long id;
		String name;
	}

	Long storeId;

	String password;

	String email;

	StoreUserStatus status;

	StoreUserRole role;


	LocalDateTime registeredAt;
	LocalDateTime unregisteredAt;
	LocalDateTime lastLoginAt;


}
