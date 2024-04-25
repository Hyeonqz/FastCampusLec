package org.example.api.common.error;

public interface ErrorCodeInterface {
	Integer getHttpStatusCode();
	Integer getErrorCode();
	String getDescription();
}
