package com.promineotech.travelplanner.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Activity {
		private int activity_id;
	 	private String activity_name;
	    private String description;
	    private String location;
	}
