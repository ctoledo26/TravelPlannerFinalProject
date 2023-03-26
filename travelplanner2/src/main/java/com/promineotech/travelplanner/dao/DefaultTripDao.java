package com.promineotech.travelplanner.dao;

import java.sql.Date;
import java.util.List;

import com.promineotech.travelplanner.entity.Trip;

public interface DefaultTripDao {

	
	// Method to retrieve all trips from the database
		List<Trip> fetchAllTrips();

		
		// Method to retrieve a specific trip by its ID
		List<Trip> fetchTripById(int activity_id);

		
		// Method to create a new trip in the database
		Trip addTrip(int trip_id, String destination, Date start_date, Date startDate, int user_id);

}