package org.example.api.domain.user.model;

import java.time.LocalDateTime;

import org.example.db.user.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {

	private Long id;
	private Long userId;
	private String name;
	private String email;
	private String password;
	private UserStatus status;
	private String address;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private LocalDateTime lastLoginAt;
}
