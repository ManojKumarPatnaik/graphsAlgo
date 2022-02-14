package com.epam.pmt.exceptions;

public class AccountDoesNotExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountDoesNotExistException(String message) {
		super(message);
	}
}