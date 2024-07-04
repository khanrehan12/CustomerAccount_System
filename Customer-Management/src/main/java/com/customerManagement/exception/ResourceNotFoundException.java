package com.customerManagement.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	public String message;
    public ResourceNotFoundException(String message)
    {
        super(message);
    }

    public ResourceNotFoundException()
    {
        super("Resource Not found !!");
    }
}
