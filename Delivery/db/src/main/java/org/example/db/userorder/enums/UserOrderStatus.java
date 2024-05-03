package org.example.db.userorder.enums;

import lombok.Getter;

@Getter
public enum UserOrderStatus {
	REGISTERED("등록"),
	UNREGISTERED("해지"),
	ORDER("주문"),
	ACCEPT("확인"),
	COOKING("조리중"),
	DELIVERING("배달중"),
	RECEIVE("배달완료"),
	;

	UserOrderStatus (String description) { // or @AllArgsConstructor 생성
		this.description = description;
	}

	private String description;
}
