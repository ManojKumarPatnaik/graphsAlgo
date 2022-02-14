package com.epam.pmt.exceptions;

public class InvalidLoginDetail extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidLoginDetail(String message) {
		super(message);
	}
}
