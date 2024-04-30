package org.example.api.exceptionhandler;

import org.example.api.common.api.Api;
import org.example.api.common.exception.ApiException;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE) // 최우선적으로 처리를 시킨다 -> 즉 에러 발생시 제일 먼저 처리한다.
public class ApiExceptionHandler {

	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<Api<Object>> apiException(ApiException apiException) {
		log.error("", apiException);

		var errorCode = apiException.getErrorCodeIfs();

		return ResponseEntity.status(errorCode.getHttpStatusCode())
			.body(
				Api.ERROR(errorCode, apiException.getErrorDescription())
			);
	}

}
