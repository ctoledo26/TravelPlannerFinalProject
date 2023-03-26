package com.promineotech.travelplanner.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	 	private int user_id;
	    private String name;
	    private String email;
	    private String password;
	    
}