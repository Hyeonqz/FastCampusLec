package org.example.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreCategory {

	CHINESE_FOOD("중식","짜장면"),
	WESTERN_FOOD("양식","파스타"),
	KOREAN_FOOD("한식","비빔밥"),
	JAPANESE_FOOD("일식","오마카세"),
	FAST_FOOD("패스트푸드","편의점"),
	CHICKEN("치킨","교촌"),
	PIZZA("피자","도미노"),
	HAMBUGER("햄버거","멕도날드"),
	COFFEE_TEA("커피&차","스타벅스");

	private String display;
	private String description;
}
