package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Trip {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "triptakeofftime")
    @Temporal(TemporalType.TIME)
    private LocalTime tripTakeoffTime;
	
	@Column(name = "triparrivaltime")
    @Temporal(TemporalType.TIME)
    private LocalTime tripArrivalTime;
	
	@Column(name = "tripdate")
    @Temporal(TemporalType.DATE)
    private LocalDate tripDate;
	
	@Column(name = "vehicleid")
    private Long vehicleId;
	
	@Column(name = "tripfrom")
    private String tripFrom;
	
	

	@Column(name = "tripto")
    private String tripTo;
	
	@Column(name = "driverid")
    private Long driverId;
	
	public LocalTime getTripTakeoffTime() {
		return tripTakeoffTime;
	}

	public void setTripTakeoffTime(LocalTime tripTakeoffTime) {
		this.tripTakeoffTime = tripTakeoffTime;
	}
	
	public LocalTime getTripArrivalTime() {
		return tripArrivalTime;
	}

	public void setTripArrivalTime(LocalTime tripArrivalTime) {
		this.tripArrivalTime = tripArrivalTime;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Long getId() {
		return id;
	}

	public String getTripFrom() {
		return tripFrom;
	}

	public void setTripFrom(String tripFrom) {
		this.tripFrom = tripFrom;
	}

	public String getTripTo() {
		return tripTo;
	}

	public void setTripTo(String tripTo) {
		this.tripTo = tripTo;
	}
	
}
