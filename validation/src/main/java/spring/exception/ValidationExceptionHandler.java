package spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.model.Api;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Api<? extends Object>> validationException(
            MethodArgumentNotValidException exception
    ) {
        log.error("", exception);


        // 클라이언트에서 무슨 에러가 났는지 알 수 가 있게 하는 로직이다.

            var errorMessageList = exception.getFieldErrors()
                    .stream()
                    .map( it -> {
                        var format = "%s { %s } 은 %s";
                        var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
                        return message;
                    }).toList();

            var error = Api.Error
                    .builder()
                    .errormessage(errorMessageList)
                    .build();


            var errorResponse = Api
                    .builder()
                    .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .error(error)
                    .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);

        }

}
