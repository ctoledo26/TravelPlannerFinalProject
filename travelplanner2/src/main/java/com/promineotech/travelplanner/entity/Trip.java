package com.promineotech.travelplanner.entity;

/**

Trip entity representing a user's trip.
*/
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data

@NoArgsConstructor
@AllArgsConstructor


public class Trip {
		private int trip_id;
		private int user_id_fk;
		private String tripName;
		private String destination;
		private Date startDate;
    	private Date endDate;
}
