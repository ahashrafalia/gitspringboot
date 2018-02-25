package com.dp.exception;

public class BusinessException extends Exception {

	public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
	public BusinessException(Throwable cause) {
        super( cause);
    }
}