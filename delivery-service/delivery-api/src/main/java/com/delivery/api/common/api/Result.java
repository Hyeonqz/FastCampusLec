package com.delivery.api.common.api;

import com.delivery.api.common.error.ErrorCode;
import com.delivery.api.common.error.ErrorCodeIfs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Result {

    private Integer resultCode;
    private String resultMessage;
    private String resultDescription;

    public static Result OK () {
        var result = Result.builder()
                .resultCode(ErrorCode.OK.getErrorCode())
                .resultMessage(ErrorCode.OK.getDescription())
                .resultDescription("성공")
                .build();

        return result;
    }

    public static Result ERROR (ErrorCodeIfs errorCodeIfs) {
        var result = Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorCodeIfs.getDescription())
                .resultDescription("에러발생")
                .build();

        return result;
    }

    public static Result ERROR (ErrorCodeIfs errorCodeIfs, Throwable th) {
        var result = Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorCodeIfs.getDescription())
                .resultDescription(th.getLocalizedMessage()) // 무슨 에러가 나왔는지 알 수 있음 -> 비추하는 방법이다 (위험함)
                .build();

        return result;
    }

    public static Result ERROR (ErrorCodeIfs errorCodeIfs, String ErrorMessage) {
        var result = Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorCodeIfs.getDescription())
                .resultDescription(ErrorMessage) // 무슨 에러가 나왔는지 알 수 있음 -> 비추하는 방법이다 (위험함)
                .build();

        return result;
    }


}
