package org.example.api.exceptionhandler;

import org.example.api.common.api.Api;
import org.example.api.common.error.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice // 예외를 이곳으로 다 끌어 모은다.
@Order(value = Integer.MAX_VALUE) // 순서 지정 어노테이션 이고 가장 마지막에 실행 적용 한다.
public class GlobalExceptionHandler {
	// 모든 예외를 이 클래스로 가져온다.

	@ExceptionHandler(value = Exception.class) // 앞에서 처리하지 못한 예상치 못한 예외를 잡는다.
	public ResponseEntity<Api<Object>> exception (Exception exception) {
		// 우리의 코드에서 에러가 발생하든, 스프링부트에서 에러가 나든, 모든 에러는 위 메소드로 오게 된다.
		log.error("",exception); // 어디서 몇번째 에서 에러가 나는지 알 수 있다.

		return ResponseEntity.status(500).body(Api.ERROR(ErrorCode.SERVER_ERROR));
	}

}
