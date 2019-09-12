package com.empresa.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ApplicationExceptionCause implements Serializable {
	
	NO_STOCK("Not enough stock of this product", HttpStatus.BAD_REQUEST);
	
	private String code;
	private HttpStatus httpStatus;
		
	ApplicationExceptionCause(String code, HttpStatus httpStatus) {
		this.code = code;
		this.httpStatus = httpStatus;
	}

}
