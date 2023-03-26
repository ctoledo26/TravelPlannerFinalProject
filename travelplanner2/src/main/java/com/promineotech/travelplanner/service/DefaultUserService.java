package com.promineotech.travelplanner.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.travelplanner.dao.DefaultUserDao;
import com.promineotech.travelplanner.entity.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultUserService implements UserService {

	
	// Injecting User DAO into User Service
	@Autowired
	private DefaultUserDao userDao;

	
	// Fetches a user by ID.
	
	@Override
	public List<User> fetchUserByID(int user_id) {
	    List<User> users = userDao.fetchUserById(user_id);
	    
	    if (users.isEmpty()) {
	        log.error("User not found with user ID: {}", user_id);
	        throw new NoSuchElementException("User not found");
	    }
	    
	    log.info("User found with user ID: {}", user_id);
	    return users;
	}




	// Creates a new user.
	@Override
	public User createUser(String name, String email, String password) {
		log.info("User created successfully: " + name + email);
		return userDao.createUser(name, email, password);
	}

	// Modifies an existing user.
	@Override
	public User modifyUser(int user_id, String name, String email, String password) {
		log.info("User information updated.");
		return userDao.modifyUser(user_id, name, email, password);
	}
	
	// Deletes a user.
	@Override
	public User deleteUser(int user_id) {
		log.info("User: " + user_id + " deleted successfully.");
		return userDao.deleteUser(user_id);
	}

}

