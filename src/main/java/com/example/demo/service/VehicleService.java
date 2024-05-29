package com.example.demo.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;
	
	public VehicleService(VehicleRepository vehicleRepository) {
		
		this.vehicleRepository = vehicleRepository;
	}
	
	public Vehicle findVehicle(Vehicle vehicle) {
		
		Example<Vehicle> v = Example.of(vehicle);
		
		return vehicleRepository.findOne(v).get();
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
