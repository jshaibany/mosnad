package com.example.demo.exceptions;

public class DriverAlreadyAssignedTrip extends Exception{

	private static final long serialVersionUID = 1L;

	public DriverAlreadyAssignedTrip(String errorMessage) {
        super(errorMessage);
    }
}
