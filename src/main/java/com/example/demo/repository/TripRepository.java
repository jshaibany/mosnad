package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Trip;

public interface TripRepository extends JpaRepository<Trip,Long>{

	List<Trip> getTripByTripDate(LocalDate tripDate);
	
	List<Trip> getTripByDriverIdAndTripDate(Long driverId,LocalDate tripDate);
	
	List<Trip> getTripByVehicleIdAndTripDate(Long vehicleId,LocalDate tripDate);
	
}
