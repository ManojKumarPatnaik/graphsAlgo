package com.epam.pmt.exceptions;

public class NoGroupFoundForAccount extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoGroupFoundForAccount(String message){
        super(message);
    }
}