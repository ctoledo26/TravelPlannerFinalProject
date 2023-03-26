package com.promineotech.travelplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.travelplanner.entity.TripActivity;
import com.promineotech.travelplanner.service.TripActivityService;




@RestController

public class DefaultTripActivityController implements TripActivityController {

    @Autowired
    private TripActivityService tripActivityService;

	
    @Override
	public TripActivity addActivityToTrip(int trip_id, int activity_id) {
		return tripActivityService.addActivityToTrip(trip_id, activity_id);
	}

	@Override
	public List<TripActivity> fetchActivityinTripbyId(int trip_id) {
		return tripActivityService.fetchActivityInTripById(trip_id);

	}
}


