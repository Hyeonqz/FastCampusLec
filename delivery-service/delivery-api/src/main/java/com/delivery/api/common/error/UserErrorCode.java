package com.delivery.api.common.error;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

/*
* User 에러의 경우 1000번대 에러코드 사용
*
* */
@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeInterface{ //Enum 클래스는 상속을 받을 수 없다. 그래서 인터페이스를 사용해야 한다.
    USER_NOT_FOUND(200,1404,"사용자를 찾을 수 없습니다.")
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;

    @Override
    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public Integer getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
