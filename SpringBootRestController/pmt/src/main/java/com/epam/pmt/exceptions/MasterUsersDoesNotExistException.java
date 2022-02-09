package com.epam.pmt.exceptions;

public class MasterUsersDoesNotExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MasterUsersDoesNotExistException(String message) {
		super(message);
	}
}