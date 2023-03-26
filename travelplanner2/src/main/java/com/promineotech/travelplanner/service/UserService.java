package com.promineotech.travelplanner.service;

import java.util.List;


import com.promineotech.travelplanner.entity.User;

public interface UserService {
	
	
	// Retrieves a user with the given user ID
	List<User> fetchUserByID(int user_id);
	
	

	// Deletes a user with the given user ID
	User deleteUser(int user_id);
	
	
	// Creates a new user with the given user ID, name, email, and password
	User createUser(String name, String email, String password);
	

	// Modifies an existing user with the given user ID, name, email, and password
	User modifyUser(int user_id_k, String name, String email, String password);





}
