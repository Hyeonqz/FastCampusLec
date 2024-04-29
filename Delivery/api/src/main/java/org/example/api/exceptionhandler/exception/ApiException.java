package org.example.api.exceptionhandler.exception;

import org.example.api.common.error.ErrorCodeInterface;

public class ApiException extends RuntimeException{

	private final ErrorCodeInterface errorCodeInterface;
	private final String errorDescription;

	public ApiException(ErrorCodeInterface errorCodeInterface, String errorDescription) {
		super(errorCodeInterface.getDescription()); // 부모에게 Description 을 보낸다
		this.errorCodeInterface = errorCodeInterface;
		this.errorDescription = errorDescription;
	}
}
