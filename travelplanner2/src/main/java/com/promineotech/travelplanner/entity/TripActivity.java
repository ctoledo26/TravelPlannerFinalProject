package com.promineotech.travelplanner.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TripActivity {
	
	int trip_id;
	int activity_id;

}
