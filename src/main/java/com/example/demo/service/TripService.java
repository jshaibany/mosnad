package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Trip;
import com.example.demo.entity.TripReservation;
import com.example.demo.repository.TripRepository;
import com.example.demo.repository.TripReservationRepository;

@Service
public class TripService {

	private final TripRepository tripRepository;
	private final TripReservationRepository tripReservationRepository;
	
	public TripService(TripRepository tripRepository, TripReservationRepository tripReservationRepository) {
		this.tripRepository = tripRepository;
		this.tripReservationRepository = tripReservationRepository;
		
	}
	
	public List<Trip> getTripsByDate(LocalDate tripDate){
		
		return tripRepository.getTripByTripDate(tripDate);
	}
	
	public List<Trip> getAllTripsByDate(Trip t){
		
		Example<Trip> e = Example.of(t);
		return tripRepository.findAll(e);
	}
	
	public Trip createTrip(Trip t) {
		
		return tripRepository.save(t);
	}
	
	public Trip findTrip(Trip t) {
		
		Example<Trip> e = Example.of(t);
		return tripRepository.findOne(e).get();
	}
	
	public TripReservation createTripReservation(TripReservation tr) {
		
		return tripReservationRepository.save(tr);
	}
	
	public List<TripReservation> getAllTripReservation() {
		
		return tripReservationRepository.findAll();
	}
	
	public List<Object[]> getTotalReservationsByTripId(Long tripId) {
		
		return tripReservationRepository.findReservationCountByTripId(tripId);
	}
}
