package com.promineotech.travelplanner.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.travelplanner.dao.TripActivityDao;
import com.promineotech.travelplanner.entity.TripActivity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultTripActivityService implements TripActivityService {

    @Autowired
    private TripActivityDao tripActivityDao;

    @Override
    public List<TripActivity> fetchActivityInTripById(int trip_id) {
        List<TripActivity> activity = tripActivityDao.fetchActivityInTripById(trip_id);

		 if (activity.isEmpty()) {
			 
		        log.error("Trip not found with trip ID: {}", trip_id);
		        
		        throw new NoSuchElementException("Trip not found");
		    }
		    
	        log.info("Activities were found with trip ID: " + trip_id);
		    return activity;
			}
        

    @Override
    public TripActivity addActivityToTrip(int trip_id, int activity_id) {
        log.info("Activity added successfully to trip with ID: " + trip_id);
        return tripActivityDao.addActivityToTrip(trip_id, activity_id);
    }

}
