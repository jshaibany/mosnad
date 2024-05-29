package com.example.demo.exceptions;

public class VehicleAlreadyAssignedTrip extends Exception{

	private static final long serialVersionUID = 1L;

	public VehicleAlreadyAssignedTrip(String errorMessage) {
        super(errorMessage);
    }
}
