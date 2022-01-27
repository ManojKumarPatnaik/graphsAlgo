package com.epam.pmt.exceptions;

public class NoRecordFoundForGroup extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRecordFoundForGroup(String message){
        super(message);
    }
}