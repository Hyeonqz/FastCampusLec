package org.example.api.domain.user.controller.model.res;

import java.time.LocalDateTime;

import org.example.db.user.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
	private Long id;
	private String name;
	private String email;
	private UserStatus status;
	private String address;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private LocalDateTime lastLoginAt;
}
