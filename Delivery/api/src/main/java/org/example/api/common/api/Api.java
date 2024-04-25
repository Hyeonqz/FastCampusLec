package org.example.api.common.api;

import org.example.api.common.error.ErrorCodeInterface;

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

	public static <T> Api<T> OK (final T data) { // Generic 을 return 하며,
		var api = new Api<T>();
		api.result = Result.OK();
		api.body = data;
		return api;
	}

	// 에러 추가
	// Error 같은 경우는 body 에 넣을 값이 없다. 그러므로 Object 로 값을 받는다.
	public static Api<Object> ERROR (Result result) { // Generic 을 return 하며,
		var api = new Api<Object>();
		api.result = result;
		return api;
	}

	// 에러코드를 직접 받아서 처리하는 로직
	public static Api<Object> ERROR (ErrorCodeInterface errorCodeInterface) { // Generic 을 return 하며,
		var api = new Api<Object>();
		api.result = Result.ERROR(errorCodeInterface);
		return api;
	}

	// 에러코드 인터페이스와 최상위 예외를 받아서 처리하는 로직
	public static Api<Object> ERROR (ErrorCodeInterface errorCodeInterface,
		Throwable throwable) { // Generic 을 return 하며,
		var api = new Api<Object>();
		api.result = Result.ERROR(errorCodeInterface, throwable);
		return api;
	}

	// 메세지를 받아서 에러 처리
	public static Api<Object> ERROR (ErrorCodeInterface errorCodeInterface, String msg) { // Generic 을 return 하며,
		var api = new Api<Object>();
		api.result = Result.ERROR(errorCodeInterface, msg);
		return api;
	}

}
