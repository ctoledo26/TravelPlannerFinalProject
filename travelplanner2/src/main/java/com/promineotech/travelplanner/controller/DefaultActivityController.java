package com.promineotech.travelplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.travelplanner.entity.Activity;
import com.promineotech.travelplanner.service.ActivityService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultActivityController implements ActivityController {

    @Autowired
    private ActivityService activityService;


	@Override
	public List<Activity> fetchActivityById(int activity_id) {
		 log.info("Getting activity with id: {}", activity_id);
	        return activityService.fetchActivityByID(activity_id);

	}


	@Override
	public Activity createActivity(String activity_name, String description, String location) {
		return activityService.createActivity(activity_name, description, location);
	}

}
