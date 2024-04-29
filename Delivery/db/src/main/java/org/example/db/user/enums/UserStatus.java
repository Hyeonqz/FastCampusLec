package org.example.db.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
	// ENUM 은 대문자로 사용한다.
	REGISTERED("등록"),
	UNREGISTERED("해지"),
	;

	private final String description;
}
