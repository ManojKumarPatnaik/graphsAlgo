package com.epam.pmt.exceptions;

public class MasterUserAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MasterUserAlreadyExistsException( String message) {
		super(message);
	}
}
