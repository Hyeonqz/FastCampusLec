package org.example.flow.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ApplicationAdvice  {

	// Exception 이 발생했을 때 아래 작업을 해주는 코드
	@ExceptionHandler(ApplicationException.class)
	Mono<ResponseEntity<ServletExceptionResponse>> applicationExceptionHandler(ApplicationException ex) {
		return Mono.just(ResponseEntity
			.status(ex.getHttpStatus())
			.body(new ServletExceptionResponse(ex.getCode(), ex.getReason()))
		);
	}

	public record ServletExceptionResponse(String code, String reason) {

	}
}
