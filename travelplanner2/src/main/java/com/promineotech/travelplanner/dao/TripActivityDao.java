package com.promineotech.travelplanner.dao;

import java.util.List;

import com.promineotech.travelplanner.entity.TripActivity;

public interface TripActivityDao {

	List<TripActivity> fetchActivityInTripById(int activity_id);

	TripActivity addActivityToTrip(int trip_id, int activity_id);

}
