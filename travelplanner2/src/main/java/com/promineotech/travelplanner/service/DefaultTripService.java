package com.promineotech.travelplanner.service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.travelplanner.dao.DefaultTripDao;
import com.promineotech.travelplanner.entity.Trip;
import com.promineotech.travelplanner.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultTripService implements TripService {

	
	// Injecting Trip DAO into Trip Service
	@Autowired
	private DefaultTripDao tripDao;

	
	// Fetches a trip by ID
	@Override
	public List<Trip> fetchTripByID(int trip_id) {
	    List<Trip> trip = tripDao.fetchTripById(trip_id);

		 if (trip.isEmpty()) {
			 
		        log.error("Trip not found with trip ID: {}", trip_id);
		        
		        throw new NoSuchElementException("Trip not found");
		    }
		    
			log.info("A trip was found with ID:" + trip_id);
		    return trip;
			}

	// Creates a new trip
	@Override
	public Trip createTrip(int trip_id, String destination, Date start_date, Date end_date, int user_id) {
	    log.info("Trip created successfully: " + trip_id + ", " + destination + ", " + start_date + ", " + end_date + ", " + user_id);
	    return tripDao.addTrip(trip_id, destination, start_date, end_date, user_id);
	}

	// Fetches all trips
	@Override
	public List<Trip> FetchAllTrips() {
		return tripDao.fetchAllTrips();
	
	}

}

