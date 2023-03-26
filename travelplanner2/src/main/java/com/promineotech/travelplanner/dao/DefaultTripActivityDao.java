package com.promineotech.travelplanner.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.travelplanner.entity.TripActivity;



@Component
public class DefaultTripActivityDao implements TripActivityDao {

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<TripActivity> fetchActivityInTripById(int activity_id) {
		String sql = ""
				+ "SELECT trip_id, activity_id "
				+ "FROM trip_activities "
				+ "WHERE activity_id = :activity_id";
		
		
			Map<String, Object> params = new HashMap<>();
			params.put("activity_id", activity_id);
				

			 return jdbcTemplate.query(sql, params, (rs, rowNum) -> TripActivity.builder()
					 .trip_id(rs.getInt("trip_id"))
		                .activity_id(rs.getInt("activity_id"))
		                .build());
	}

	@Override
	public TripActivity addActivityToTrip(int trip_id, int activity_id) {
		String sql = ""
				+ "INSERT INTO trip_activities (trip_id, activity_id) VALUES (:trip_id, :activity_id)";
		
				Map<String, Object> params = new HashMap<>();
				params.put("trip_id", trip_id);
				params.put("activity_id", activity_id);	
				
				jdbcTemplate.update(sql, params);
				return TripActivity.builder()
						.trip_id(trip_id)
						.activity_id(activity_id)
						.build();
				
	}

}
