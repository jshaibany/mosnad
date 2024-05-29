package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;
	
	public VehicleService(VehicleRepository vehicleRepository) {
		
		this.vehicleRepository = vehicleRepository;
	}
	
	public Vehicle createVehicle(Vehicle v) {
		
		return vehicleRepository.save(v);
	}
	
	public Vehicle updateVehicle(Vehicle v) {
		
		return vehicleRepository.save(v);
	}
	
	public void deleteVehicle(Vehicle v) {
		
		vehicleRepository.delete(v);
	}
}
