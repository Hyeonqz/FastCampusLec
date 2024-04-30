package org.example.api.common.exception;

import org.example.api.common.error.ErrorCodeInterface;

public interface ApiExceptionIfs {
	ErrorCodeInterface getErrorCodeIfs();
	String getErrorDescription();
}
