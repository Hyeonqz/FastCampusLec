package org.example.db.userordermenu.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserOrderMenuStatus {
	REGISTERED("등록"),
	UNREGISTERED("해지")
	;


	private String description;
}
