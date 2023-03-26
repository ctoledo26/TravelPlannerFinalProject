package com.promineotech.travelplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.travelplanner.entity.User;
import com.promineotech.travelplanner.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUserController implements UserController{

    @Autowired
    private UserService userService;
   

	public User createUser(String name, String email, String password) {
		return userService.createUser(name, email, password);
	}

	@Override
	public User modifyUser(int user_id, String name, String email, String password) {
        return userService.modifyUser(user_id, name, email, password);
	}
	
    	

		@Override
		public List<User> fetchUserById(int user_id) {
			 log.info("Getting user with id: {}", user_id);
		        return userService.fetchUserByID(user_id);
	
	
		}

		@Override
		public User deleteUser(int user_id) {
			log.info("Deleting user with id: {}", user_id);
	        return userService.deleteUser(user_id);
	    }
		
		}


	

