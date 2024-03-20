package com.delivery.api.common.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeIfs {

    // 유저의 경우 1000번대 에러 코드 사용한다.
    USER_NOT_FOUND(400, 1404, "사용자를 찾을 수 없음"),

    ;

    private final Integer httStatusCode;
    private final Integer errorCode;
    private final String description;

    @Override
    public Integer getHttpStatusCode() {
        return this.httStatusCode;
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
