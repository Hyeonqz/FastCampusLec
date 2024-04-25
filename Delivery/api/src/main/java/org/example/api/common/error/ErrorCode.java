package org.example.api.common.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // 인터페이스 구현체 를 만들기 위함
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeInterface{
	OK(200, 200, "성공"),
	BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청 -> 클라이언트 에러"),
	SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "잘못된 응답 -> 서버에러"),
	NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null Point Exception")
	;

	private final Integer httpStatusCode;
	private final Integer errorCode;
	private final String description;
}
