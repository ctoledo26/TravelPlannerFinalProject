package com.promineotech.travelplanner.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.travelplanner.entity.User;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class UserDao implements DefaultUserDao {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    /**
     * Fetches a user by their user ID.
     * 
     * @param user_id The user ID to search for.
     * @param email The email associated with user ID searched for.
     * @param name The name of associated with the User ID searched for.
     * @return A list of users with the specified ID.
     */
    @Override
    public List<User> fetchUserById(int user_id) {
        String sql = ""
        	 + "SELECT * "
                 + "FROM users "
                 + "WHERE user_id = :user_id ";

        Map<String, Object> params = new HashMap<>();
        params.put("user_id", user_id);
       

        // Executes the query and returns a list of User objects.
        return jdbcTemplate.query(sql, params, (rs, rowNum) -> User.builder()
                .user_id(rs.getInt("user_id"))
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .build());
    }
    /**
     * Fetches all users in the database.
     * 
     * @return A list of all users in the database.
     */
    @Override
    public List<User> fetchAllUsers() {
        String sql = ""
                + "SELECT * "
                + "FROM users ";
        
        // Executes the query and returns a list of User objects.
        return jdbcTemplate.query(sql, (rs, rowNum) -> User.builder()
                .user_id(rs.getInt("user_id"))
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .build());
    }


    /**
     * Creates a new user with the specified parameters.
     * 
     * @param user_id The user ID to assign to the new user.
     * @param name The name of the new user.
     * @param email The email of the new user.
     * @param password The password of the new user.
     * @return The newly created User object.
     */
    @Override
    public User createUser(String name, String email, String password) {
        log.info("DAO: name={}, email={}, password={}", name, email, password);
        
        String sql = ""
                + "INSERT INTO users (name, email, password) VALUES (:name, :email, :password)";

        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);

        // Executes the SQL statement to create the new user.
        jdbcTemplate.update(sql, params);
        
        // Returns the newly created User object.[-l,
        return User.builder()
        		.name(name)
        		.email(email)
        		.password(password)
        		.build();
    }

       
    /**
     * Deletes a user with the specified user ID.
     * 
     * @param user_id The user ID of the user to delete.
     * @return The User object of the deleted user.
     */
    @Override
    public User deleteUser(int user_id) {
        String sql = ""
                + "DELETE FROM users WHERE "
                + "user_id = :user_id;";

        Map<String, Object> params = new HashMap<>();
        params.put("user_id", user_id);

        // Executes the SQL statement to delete the user.
        jdbcTemplate.update(sql, params);
        return User.builder().user_id(user_id).build();
    }

    // Modifies an existing user with the given user ID, name, email, and password.
	@Override
	public User modifyUser(int user_id, String name, String email, String password) {
		 log.info("DAO: userId={}, name={}, password={}", user_id, name, password);

     	//@formatter:off
     String sql = ""
             + "UPDATE user "
             + "SET name = :name, "
             + "password = :password "
             + "WHERE user_id = :userId;";

     Map<String, Object> params = new HashMap<>();
     params.put("userId", user_id);
     params.put("name", name);
     params.put("password", password);

     jdbcTemplate.update(sql, params);

     return User.builder()
             .user_id(user_id)
             .name(name)
             .password(password)
             .build();
 

 			//@formatter:on

	}


	}


   
   

