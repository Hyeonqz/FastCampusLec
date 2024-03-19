package com.delivery.api.common.api;

import com.delivery.api.common.error.ErrorCodeInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Api<T> { // 원하는 데이터를 넣기 위해서 제네릭 타입으로 클래스를 설정한다.

    private Result result;

    @Valid
    private T body;

    public static <T> Api<Object> ok(T data) {
        var api = new Api();
        api.result = Result.OK();
        api.body = data;
        return api;
    }

    public static Api<Object> ERROR(Result result) {
        var api = new Api<Object>();
        api.result = result;
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface);
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, Throwable tx) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface,tx);
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, String description) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface,description);
        return api;
    }

}
