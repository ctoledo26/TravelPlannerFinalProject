package com.promineotech.travelplanner.dao;

import java.util.List;

import com.promineotech.travelplanner.entity.Activity;

public interface DefaultActivityDao {
   
	
	// Method to retrieve all activities from the database
	List<Activity> fetchAllActivities();

	// Method to retrieve a specific activity by its ID
	List<Activity> fetchActivityById(int activity_id);

	
	// Method to create a new activity in the database
	Activity createActivity(String activity_name, String description, String location);



    
 
}
