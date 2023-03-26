package com.promineotech.travelplanner.dao;

import java.util.List;

import com.promineotech.travelplanner.entity.User;

public interface DefaultUserDao {
 
	
	//Takes in a user id and returns a list of user objects that match the id.
    List<User> fetchUserById(int user_id);

    //Returns a list of all user objects.
    List<User> fetchAllUsers();

    //Takes in a user id, name, email, and password, and creates a new user object with that information.
	User createUser(String name, String email, String password);


	//Takes in a user id, name, email, and password and modifies the corresponding user object with the new information.
	User modifyUser(int user_id, String name, String email, String password);

	//Takes in a user id and deletes the corresponding user object.
	User deleteUser(int user_id);
	
	}


