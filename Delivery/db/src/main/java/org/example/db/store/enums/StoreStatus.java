package org.example.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreStatus {
	REGISTERED("등록"),
	UNREGISTERED("해지"),
	WAIT_REGISTERED("등록 대기"),
	WAIT_UNREGISTERED("해지 대기")
	;

	private String description;
}
