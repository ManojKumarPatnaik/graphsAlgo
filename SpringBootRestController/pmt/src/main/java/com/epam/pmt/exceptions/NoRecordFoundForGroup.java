package com.epam.pmt.exceptions;

public class NoRecordFoundForGroup extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRecordFoundForGroup(String message){
        super(message);
    }
}