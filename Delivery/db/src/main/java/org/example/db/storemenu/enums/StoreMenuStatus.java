package org.example.db.storemenu.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreMenuStatus {
	REGISTERED("등록"),
	UNREGISTERED("해지"),
	WAIT_REGISTERED("대기")
	;

	private String description;
}
