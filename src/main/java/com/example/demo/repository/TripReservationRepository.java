package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.TripReservation;

public interface TripReservationRepository extends JpaRepository<TripReservation,Long>{

	 @Query(value = "SELECT COUNT(*) AS total_reservations, tripid FROM trip_reservation WHERE tripid= :tripId GROUP BY tripid", nativeQuery = true)
	 List<Object[]> findReservationCountByTripId(Long tripId);
}
