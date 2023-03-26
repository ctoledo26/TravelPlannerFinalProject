package com.promineotech.travelplanner.dao;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
	import org.springframework.stereotype.Component;

import com.promineotech.travelplanner.entity.Activity;

	import lombok.extern.slf4j.Slf4j;

	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	@Slf4j
	@Component
	public class ActivityDao implements DefaultActivityDao {


	    @Autowired
	    private NamedParameterJdbcTemplate jdbcTemplate;

	 // Retrieve activity by ID
	    @Override
	    public List<Activity> fetchActivityById(int activity_id) {
	        String sql = ""
	                + "SELECT activity_id "
	                + "FROM activities "
	                + "WHERE activity_id = :activity_id ";

	        Map<String, Object> params = new HashMap<>();
	        params.put("activity_id", activity_id);

	        // Execute the query and map the results to the Activity entity class
	        return jdbcTemplate.query(sql, params, (rs, rowNum) -> Activity.builder()
	                .activity_id(rs.getInt("activity_id"))
	                .activity_name(rs.getString("activity_name"))
	                .description(rs.getString("description"))
	                .location(rs.getString("location"))
	                .build());
	    }
	 // Retrieve all activities
	    @Override
	    public List<Activity> fetchAllActivities() {
	        String sql = ""
	                + "SELECT * "
	                + "FROM activities ";
	      
	        // Execute the query and map the results to the Activity entity class
	        return jdbcTemplate.query(sql, (rs, rowNum) -> Activity.builder()
	                .activity_id(rs.getInt("activity_id"))
	                .activity_name(rs.getString("activity_name"))
	                .description(rs.getString("description"))
	                .location(rs.getString("location"))
	                .build());
	    }

	 // Create a new activity
	    @Override
	    public Activity createActivity(String activity_name, String description, String location) {
	        
	    	// Log the parameters passed to the method
	        log.info("DAO: activity_name={},description={},location={}", activity_name, description, location);

	        String sql = ""
	                + "INSERT INTO activities (activity_name,description,location) VALUES (:activity_name, :description,:location)";

	        Map<String, Object> params = new HashMap<>();
	        params.put("activity_name", activity_name);
	        params.put("description", description);
	        params.put("location", location);

	        
	        // Execute the query and insert the new activity into the database

	        jdbcTemplate.update(sql, params);
	        
	        // Return the newly created activity
	       return Activity.builder().activity_name(activity_name).build();
	    }

		}
	   
