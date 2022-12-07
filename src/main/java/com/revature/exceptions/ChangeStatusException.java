package com.revature.exceptions;

public class ChangeStatusException extends Exception{
    
    private static final long serialVersionUID = 1L;


    public ChangeStatusException(){
        super();
    }

    public ChangeStatusException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ChangeStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChangeStatusException(String message) {
		super(message);
	}

	public ChangeStatusException(Throwable cause) {
		super(cause);
	}

}
