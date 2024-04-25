package org.example.api.common.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> { // Generic 으로 선언 이유는 뭐가 들어올지 모르기 때문 이다.

	// API 표즌 스펙을 지정하기 위한 클래스
	// API 호출시 제일 상단에 위치할 내용이다.

	/*
	Ex)
	* {
	* 	"result" : {

		},
	* 	"body" : {

		},
	* }
	*/
	private Result result;

	@Valid
	private T body;

	public static <T> Api<T> OK (T data) { // Generic 을 return 하며,
		var api = new Api<T>();
		api.result = Result.OK();
		api.body = data;
		return api;
	}

}
