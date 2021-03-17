package com.fink.bookstore.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> erros = new ArrayList<>();
			
	public ValidationError() {
		super();
	}

	public ValidationError(long timestamp, Integer status, String message) {
		super(timestamp, status, message);
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}
	
}
