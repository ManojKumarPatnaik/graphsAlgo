package com.epam.pmt.exceptions;

public class WrongPasswordException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongPasswordException() {
        super("Oops! Password does not matched!!");
    }
}