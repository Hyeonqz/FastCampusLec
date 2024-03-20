package com.delivery.api.exceptionhandler;

import com.delivery.api.common.api.Api;
import com.delivery.api.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Order(value = Integer.MIN_VALUE) // 최우선처리
public class ApiExceptionHandler {

    @ExceptionHandler(value= ApiException.class) // ApiException 클래스로 발생하는 모든 예외를 캐치할 것이다.
    public ResponseEntity<Api<Object>> apiException ( ApiException apiException) {
        log.error("", apiException);

        var errorCode = apiException.getErrorCodeIfs();

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body((Api<Object>) errorCode)
                ;
    }
}
