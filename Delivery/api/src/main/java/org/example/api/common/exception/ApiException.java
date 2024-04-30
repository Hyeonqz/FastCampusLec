package org.example.api.common.exception;

import org.example.api.common.error.ErrorCode;
import org.example.api.common.error.ErrorCodeInterface;

public class ApiException extends RuntimeException implements ApiExceptionIfs{

	private final ErrorCodeInterface errorCodeInterface;
	private final String errorDescription;

	public ApiException(ErrorCodeInterface errorCodeInterface) {
		super(errorCodeInterface.getDescription()); // 부모에게 Description 을 보낸다
		this.errorCodeInterface = errorCodeInterface;
		this.errorDescription = errorCodeInterface.getDescription();
	}

	public ApiException(ErrorCodeInterface errorCodeIfs, String errorDescription){
		super(errorDescription);
		this.errorCodeInterface = errorCodeIfs;
		this.errorDescription = errorDescription;
	}

	public ApiException(ErrorCodeInterface errorCodeIfs, Throwable tx){
		super(tx);
		this.errorCodeInterface = errorCodeIfs;
		this.errorDescription = errorCodeIfs.getDescription();
	}

	public ApiException(ErrorCodeInterface errorCodeIfs, Throwable tx, String errorDescription){
		super(tx);
		this.errorCodeInterface = errorCodeIfs;
		this.errorDescription = errorDescription;
	}

	@Override
	public ErrorCodeInterface getErrorCodeIfs () {
		return null;
	}

	@Override
	public String getErrorDescription () {
		return "";
	}

}
