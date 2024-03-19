package com.delivery.api.common.error;

public interface ErrorCodeInterface {
    public Integer getHttpStatusCode();
    public Integer getErrorCode();
    public String getDescription();
}
