package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TripReservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "tripid")
    private Long tripId;
	
	@Column(name = "passengername")
    private String passengerName;
	
	@Column(name = "passengeridtype")
    private String passengerIdType;
	
	@Column(name = "passengeridnumber")
    private String passengerIdNUmber;
	
	@Column(name = "passengerseatnumber")
    private String passengerSeatNUmber;
	
	public String getPassengerSeatNUmber() {
		return passengerSeatNUmber;
	}

	public void setPassengerSeatNUmber(String passengerSeatNUmber) {
		this.passengerSeatNUmber = passengerSeatNUmber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerIdType() {
		return passengerIdType;
	}

	public void setPassengerIdType(String passengerIdType) {
		this.passengerIdType = passengerIdType;
	}

	public String getPassengerIdNUmber() {
		return passengerIdNUmber;
	}

	public void setPassengerIdNUmber(String passengerIdNUmber) {
		this.passengerIdNUmber = passengerIdNUmber;
	}

	
}
