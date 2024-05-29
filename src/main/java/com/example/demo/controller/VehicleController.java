package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Trip;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController {

	private final VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
		
	}
	
	@PostMapping
    @RequestMapping("/api/vehicle/new")
    @ResponseBody
    public HashMap<String,Object> createVehicle(@RequestBody Vehicle vehicle) {
		
		HashMap<String,Object> response = new HashMap<>();
		try{
		      
			Vehicle v = vehicleService.createVehicle(vehicle);
		    
			response.put("Vehicle", v);
			response.put("Result", 0);
			
			return response;
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      response.put("Vehicle", null);
			
		      response.put("Result", -1);
		      return response;
		} 
	}
	
	@PostMapping
    @RequestMapping("/api/vehicle/update")
    @ResponseBody
    public HashMap<String,Object> updateVehicle(@RequestBody Vehicle vehicle) {
		
		HashMap<String,Object> response = new HashMap<>();
		try{
		      
			Vehicle v = vehicleService.updateVehicle(vehicle);
		    
			response.put("Vehicle", v);
			response.put("Result", 0);
			
			return response;
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      response.put("Vehicle", null);
			
		      response.put("Result", -1);
		      return response;
		} 
	}
	
	@PostMapping
    @RequestMapping("/api/vehicle/delete")
    @ResponseBody
    public HashMap<String,Object> deleteVehicle(@RequestBody Vehicle vehicle) {
		
		HashMap<String,Object> response = new HashMap<>();
		try{
		      
			vehicleService.deleteVehicle(vehicle);
		    
			response.put("Result", 0);
			
			return response;
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      response.put("Vehicle", null);
			
		      response.put("Result", -1);
		      return response;
		} 
	}
}
