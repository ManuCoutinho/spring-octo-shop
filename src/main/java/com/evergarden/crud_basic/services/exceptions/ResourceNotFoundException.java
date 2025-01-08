package com.evergarden.crud_basic.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(Object id) {
		super("Resource not found. ID " + id);
	}

}
