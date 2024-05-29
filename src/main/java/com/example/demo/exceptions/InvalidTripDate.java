package com.example.demo.exceptions;

public class InvalidTripDate extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTripDate(String errorMessage) {
        super(errorMessage);
    }
}
