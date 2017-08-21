package com.example.exception;

import org.springframework.http.HttpStatus;

public class RestWineException extends Exception {
	protected boolean isThereError;
	protected HttpStatus statusError;
	public RestWineException(boolean isThereError, String message,HttpStatus statusError) {
		super(message);
		this.isThereError = isThereError;
		this.statusError = statusError;
	}
	public boolean isThereError() {
		return isThereError;
	}
	public HttpStatus getStatusError() {
		return statusError;
	}
	
}
