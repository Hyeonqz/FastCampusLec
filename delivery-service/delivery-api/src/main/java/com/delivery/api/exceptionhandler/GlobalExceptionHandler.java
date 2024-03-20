package com.delivery.api.exceptionhandler;

import com.delivery.api.common.api.Api;
import com.delivery.api.common.api.Result;
import com.delivery.api.common.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice // 예외를 이걸로 끌어들임
@Order(value = Integer.MAX_VALUE) // 여러가지 예외에 대한 순서를 지정해주는 어노테이션.
public class GlobalExceptionHandler {

    // 우리가 예상하지 못한 예외를 잡는다.
    // 컨트롤러에서 에러 응답을 내려주나. Exception 으로 내려주나 클라이언트에서는 동일한 응답을 받는다.
    // 그러므로 코드의 분리를 해준다.
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api<Object>> exception(Exception exception) { // Spring 이 예외를 받아준다.
        log.error("", exception);

        return ResponseEntity
                .status(500)
                .body(Api.ERROR(Result.ERROR(ErrorCode.SERVER_ERROR)));



    }
}
