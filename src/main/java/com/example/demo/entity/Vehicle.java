package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	
	private String vehicletype;
	private String vehicleplate;
	private Integer vehicletotalseats;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public String getVehicleplate() {
		return vehicleplate;
	}
	public void setVehicleplate(String vehicleplate) {
		this.vehicleplate = vehicleplate;
	}
	public Integer getVehicletotalseats() {
		return vehicletotalseats;
	}
	public void setVehicletotalseats(Integer vehicletotalseats) {
		this.vehicletotalseats = vehicletotalseats;
	}
}
