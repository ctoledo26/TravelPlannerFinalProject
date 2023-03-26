package com.promineotech.travelplanner.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.travelplanner.dao.DefaultActivityDao;
import com.promineotech.travelplanner.entity.Activity;
import com.promineotech.travelplanner.entity.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultActivityService implements ActivityService {


	// Injecting Activity DAO into Activity Service
	@Autowired
	private DefaultActivityDao activityDao;

	
	// Fetches the activity with the given activity ID.
	@Override
	public List<Activity> fetchActivityByID(int activity_id) {
		    log.info("Activity found with activity ID: {}", activity_id);
		    return activityDao.fetchActivityById(activity_id);
	}

	// Creates a new activity with the given activity ID, name, description, and location.
	@Override
	public Activity createActivity(String activity_name, String description, String location) {
		log.info("Activity created successfully: " + activity_name, description,location);
		return activityDao.createActivity(activity_name, description,location);
	}

	@Override
		public List<Activity> fetchAllActivities() {
		    log.info("Fetching all activities...");
		    return activityDao.fetchAllActivities();
		}

	}
