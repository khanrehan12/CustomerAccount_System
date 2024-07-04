package com.customerManagement.exception;

public class NotAcceptableException extends RuntimeException{
	
	public String message;
    public NotAcceptableException(String message)
    {
        super(message);
    }

    public NotAcceptableException()
    {
        super("Values Not Acceptable !!");
    }

}
