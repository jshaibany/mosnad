package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Trip;
import com.example.demo.entity.TripReservation;
import com.example.demo.service.TripService;

@RestController
public class TripController {

	private final TripService tripService;
	
	public TripController(TripService tripService) {
		this.tripService = tripService;
		
	}
	
	@PostMapping
    @RequestMapping("/api/trip/getByDate")
    @ResponseBody
    public List<Trip> getTripsByDate(@RequestBody HashMap<String,String> payload) {
		
		try{
		      LocalDate localDate = LocalDate.parse(payload.get("tripDate"));
		      System.out.println(localDate);
		      
		      return tripService.getTripsByDate(localDate);
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      return null;
		} 
	}
	
	@PostMapping
    @RequestMapping("/api/trip/getAllByDate")
    @ResponseBody
    public List<Trip> getAllTripsByDate(@RequestBody HashMap<String,String> payload) {
		
		try{
			
			Trip t = new Trip();
			t.setTripDate(LocalDate.parse(payload.get("tripDate")));

		    return tripService.getAllTripsByDate(t);
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      return null;
		} 
	}
	
	@PostMapping
    @RequestMapping("/api/trip/create")
    @ResponseBody
    public HashMap<String,Object> createTrip(@RequestBody Trip trip) {
		
		HashMap<String,Object> response = new HashMap<>();
		
		try{
			
			Trip t = tripService.createTrip(trip);

		    response.put("Trip", t);
		    response.put("Result", 0);
		    
		    return response;
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      response.put("Message", "Exception caught!");
		      response.put("Result", -1);
		      
		      return response;
		} 
	}
	
	@PostMapping
    @RequestMapping("/api/trip/reservations/create")
    @ResponseBody
    public HashMap<String,Object> createTripReservation(@RequestBody TripReservation tripReservation) {
		
		HashMap<String,Object> response = new HashMap<>();
		
		try{
			
			TripReservation tr = tripService.createTripReservation(tripReservation);

		    response.put("Reservation", tr);
		    response.put("Result", 0);
		    
		    return response;
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      response.put("Message", "Exception caught!");
		      response.put("Result", -1);
		      
		      return response;
		} 
	}
	
	@GetMapping
    @RequestMapping("/api/trip/reservations/getall")
    @ResponseBody
    public HashMap<String,Object> getAllTripReservation() {
		
		HashMap<String,Object> response = new HashMap<>();
		
		try{
			
			List<TripReservation> tr = tripService.getAllTripReservation();
			
		    response.put("Reservation", tr);
		    response.put("Result", 0);
		    
		    return response;
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      response.put("Message", "Exception caught!");
		      response.put("Result", -1);
		      
		      return response;
		} 
	}
	
	@GetMapping
    @RequestMapping("/api/trip/reservations/gettotalbytrip")
    @ResponseBody
    public HashMap<String,Object> getAllTripReservationsByTrip(@RequestParam String tripId) {
		
		HashMap<String,Object> response = new HashMap<>();
		Long Id = Long.parseLong(tripId);
		
		try{
			
			List<Object[]> l = tripService.getTotalReservationsByTripId(Id);
			
			Object[] row = l.get(0);
			System.out.println(String.format("%s Total Reserv, Trip %s", row[0].toString(),Id));
			
		    response.put("Reservations", row[0]);
		    response.put("Trip", Id);
		    response.put("Result", 0);
		    
		    return response;
		    
		}catch (Exception e) {
		      System.out.println("Error parsing date: " + e.getMessage());
		    
		      response.put("Message", "Exception caught!");
		      response.put("Result", -1);
		      
		      return response;
		} 
	}
}