package org.example.api.common.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
* User 에러의 경우 우리가 임의적으로 1000번 대를 에러코드로 사용해서 한다.
*
* */
@Getter // 인터페이스 구현체 를 만들기 위함
@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeInterface{
	USER_NOT_FOUND(400, 1404, "사용자를 찾을 수 없음"),
	;

	private final Integer httpStatusCode;
	private final Integer errorCode;
	private final String description;

}
