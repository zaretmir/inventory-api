package com.empresa.exception;

import org.springframework.http.HttpStatus;


public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 2435263913277497590L;
	
	private HttpStatus status;
	private String message;	// User-friendly error message
	
	public ApplicationException(ApplicationExceptionCause cause) {
		this.status = cause.getHttpStatus();
		this.message = cause.getCode();
	}
	
	public HttpStatus getStatus() {
		return this.status;
	}
	
	public String getMessage() {
		return this.message;
	}
}
