package com.fink.bookstore.service.exceptions;

public class DataIntegrityViolationExcept  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationExcept(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationExcept(String message) {
		super(message);
	}	
}
