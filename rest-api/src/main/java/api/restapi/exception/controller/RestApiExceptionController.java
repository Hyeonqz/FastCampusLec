package api.restapi.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@Slf4j
@RestController
public class RestApiExceptionController {

    @GetMapping("/except")
    public void hello() {
        var list = List.of("hello");
        var element = list.get(1);
        log.info("element {}",element);
        throw new RuntimeException("run time exception call");
    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e) {
        log.error("IndexOutOfBoundsException : {}", e);
        return ResponseEntity.status(200).build();
    }
}
