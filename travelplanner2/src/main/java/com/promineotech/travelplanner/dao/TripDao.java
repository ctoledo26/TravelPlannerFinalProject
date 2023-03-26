package com.promineotech.travelplanner.dao;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.travelplanner.entity.Trip;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	@Slf4j
	@Component
	public class TripDao implements DefaultTripDao {


		// Inject the JdbcTemplate
	    @Autowired
	    private NamedParameterJdbcTemplate jdbcTemplate;

	    
		 // Retrieve trip by ID
	    @Override
	    public List<Trip> fetchTripById(int trip_id) {
	        String sql = ""
	                + "SELECT * "
	                + "FROM trips "
	                + "WHERE trip_id = :trip_id ";

	        Map<String, Object> params = new HashMap<>();
	        params.put("trip_id", trip_id);

	        // Execute the query and map the results to the Trip entity class

	        return jdbcTemplate.query(sql, params, (rs, rowNum) -> Trip.builder()
	                .trip_id(rs.getInt("trip_id"))
	                .destination(rs.getString("destination"))
	                .startDate(rs.getDate("startDate"))
	                .endDate(rs.getDate("endDate"))
	                .build());
	    }
	
	    
	    // Retrieve all trips
	    @Override
	    public List<Trip> fetchAllTrips() {
	        String sql = ""
	                + "SELECT * "
	                + "FROM trips ";
	        
	        return jdbcTemplate.query(sql, (rs, rowNum) -> Trip.builder()
	        		.trip_id(rs.getInt("trip_id"))
	                .tripName(rs.getString("tripName"))
	                .destination(rs.getString("destination"))
	                .startDate(rs.getDate("startDate"))
	                .endDate(rs.getDate("endDate"))
	                .build());
	    }

	 // Create a new trip
	    @Override
	    public Trip addTrip(int trip_id,String destination, Date startDate, Date endDate, int user_id) {
	        
	    	// Log the parameters passed to the method
	        log.info("DAO: trip_id={} ,tripName={}, destination={},startDate={},endDate={}", trip_id, destination, destination,startDate,endDate);

	        String sql = ""
	        	    + "INSERT INTO trips (tripName, destination, startDate, endDate) "
	        	    + "VALUES (:tripName, :destination, :startDate, :endDate)";


	        Map<String, Object> params = new HashMap<>();
	        params.put("destintion", destination);
	        params.put("startDate", startDate);
	        params.put("endDate", endDate);
	       
	        // Execute the query and insert the new trip into the database
	        jdbcTemplate.update(sql, params);

	        // Return the newly created trip.
	       return Trip.builder()
	    		   .destination(destination)
	    		   .startDate(startDate)
	    		   .endDate(endDate)
	    		   .build();
	    }

		}