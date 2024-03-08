package api.restapi.exception.controller;

import api.restapi.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
// 이 케이스를 자주 사용한다.
@RestControllerAdvice(basePackages = "api.restapi.exception.controller") //이 클래스에서 REST API가 사용하는 곳에 예외가 일어나는 것을 감지를 한다
public class ExceptionHandler1 {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception e) {
        log.error("exception : {}",e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public Api noSuchElement(NoSuchElementException e) {
        log.error("",e);
        return Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
    }
}
