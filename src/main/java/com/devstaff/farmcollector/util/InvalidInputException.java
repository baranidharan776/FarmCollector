package com.devstaff.farmcollector.util;

public class InvalidInputException extends RuntimeException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String field) {
	        super("Invalid Input for the given field - " + field + ". Try again with a valid one");
	    }

}
