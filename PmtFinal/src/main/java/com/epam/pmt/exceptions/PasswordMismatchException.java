package com.epam.pmt.exceptions;

public class PasswordMismatchException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		super("Oops! Password Mismatched");
		// TODO Auto-generated constructor stub
	}

	public PasswordMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PasswordMismatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordMismatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordMismatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	

}
