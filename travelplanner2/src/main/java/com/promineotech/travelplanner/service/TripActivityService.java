package com.promineotech.travelplanner.service;

import java.util.List;

import com.promineotech.travelplanner.entity.TripActivity;

public interface TripActivityService {

	
	List<TripActivity> fetchActivityInTripById(int activity_id);

	TripActivity addActivityToTrip(int trip_id, int activity_id);


    }


