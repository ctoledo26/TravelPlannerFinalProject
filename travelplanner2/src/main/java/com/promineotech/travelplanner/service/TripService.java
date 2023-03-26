package com.promineotech.travelplanner.service;

import java.sql.Date;
import java.util.List;

import com.promineotech.travelplanner.entity.Trip;

public interface TripService {

	List<Trip> FetchAllTrips();

	// Creates a new trip 
	Trip createTrip(int trip_id, String destination, Date start_date, Date end_date, int user_id);

	// Retrieves a trip
	List<Trip> fetchTripByID(int trip_id);

}
