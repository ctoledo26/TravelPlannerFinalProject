package com.promineotech.travelplanner.service;

import java.util.List;

import com.promineotech.travelplanner.entity.Activity;

public interface ActivityService {
	
    
   
    // Method to fetch activity by ID
	List<Activity> fetchActivityByID(int activity_id);

    // Method to create a new activity with provided details
	Activity createActivity(String activity_name, String description, String location);

    // Method to fetch all activities
	List<Activity> fetchAllActivities();


    }
