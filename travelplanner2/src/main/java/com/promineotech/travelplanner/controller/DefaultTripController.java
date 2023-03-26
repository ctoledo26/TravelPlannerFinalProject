package com.promineotech.travelplanner.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.promineotech.travelplanner.entity.Trip;
import com.promineotech.travelplanner.service.TripService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

public class DefaultTripController implements TripController {

    @Autowired
    private TripService tripService;

    // Create a trip    
    @Override
    public Trip createTrip(int trip_id, String destination, Date startDate, Date endDate, int user_id){
		log.info("Adding trip with ID= {} to user with ID ={}", trip_id, user_id);
      
		// Call the createTrip method of the TripService class to add the trip

    	return tripService.createTrip(trip_id,destination,startDate, endDate, user_id);
    }
    // Fetch trips by user ID

	@Override
	public List<Trip> fetchTripById(int user_id) {
			log.info("Fetching trips for user with ID = {}", user_id);
	        // Call the fetchTripByID method of the TripService class to get a list of trips

	        return tripService.fetchTripByID(user_id);
	}




}


   