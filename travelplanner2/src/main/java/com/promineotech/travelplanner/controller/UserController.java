package com.promineotech.travelplanner.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.travelplanner.entity.User;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/users")
@OpenAPIDefinition(info = @Info(title = "Travel Planner "), servers = {
	    @Server(url = "http://localhost:8080", description = "Localserver.")})
public interface UserController {
	
	
	//@formatter: off
	
		@Operation(
		      summary = "Gets user by ID",
		      responses = {
		          @ApiResponse(
		        		  responseCode = "200", 
		        		  description = "User found", 
		        		  content = @Content(
		        				  mediaType = "application/json", 
		        				  schema = @Schema(implementation = User.class))),
		          @ApiResponse(responseCode = "400", 
		          		description = "Invalid request", 
		          		content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404",
		          		description = "User not found", 
		          		content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500",
		          		description = "An unplanned error occurred.", 
				         content = @Content(mediaType = "application/json"))

		      },

		    		  parameters = {
		    		          @Parameter(name = "user_id", allowEmptyValue = false, required = false,
										description = "Enter the user ID")
		    		        		  
		      }
		    		              )
		    		          
		      
		  		@GetMapping
		        @ResponseStatus(code = HttpStatus.OK)

					List<User> fetchUserById(@RequestParam(required = true)
						int user_id);
		          @Operation(
		        		    summary = "Create a new user",
		        		    responses = {
		        		        @ApiResponse(
		        		            responseCode = "201",
		        		            description = "User created",
		        		            content = @Content(
		        		                mediaType = "application/json",
		        		                schema = @Schema(implementation = User.class)
		        		            )
		        		        ),
		        		        @ApiResponse(
		        		            responseCode = "500",
		        		            description = "An unplanned error occurred.",
		        		            content = @Content(mediaType = "application/json")
		        		        )
		        		    }
		        		)
		        		@PostMapping
		        		@ResponseStatus(code = HttpStatus.CREATED)
		        		User createUser(
		        				 		        	

		        		    @Parameter(
		        		        name = "name",
		        		        allowEmptyValue = false,
		        		        required = true,
		        		        description = "Enter your name"
		        		    )
		        		    @RequestParam String name,

		        		    @Parameter(
		        		        name = "email",
		        		        allowEmptyValue = false,
		        		        required = true,
		        		        description = "Enter your email"
		        		    )
		        		    @RequestParam String email,

		        		    @Parameter(
		        		        name = "password",
		        		        allowEmptyValue = false,
		        		        required = true,
		        		        description = "Enter a password"
		        		    )
		        		    @RequestParam String password
		        		);


		        		@Operation(
		        		    summary = "Update a user",
		        		    responses = {
		        		        @ApiResponse(
		        		            responseCode = "200",
		        		            description = "User updated",
		        		            content = @Content(
		        		                mediaType = "application/json",
		        		                schema = @Schema(implementation = User.class)
		        		            )
		        		        ),
		        		        @ApiResponse(
		        		            responseCode = "404",
		        		            description = "User not found",
		        		            content = @Content(mediaType = "application/json")
		        		        ),
		        		        @ApiResponse(
		        		            responseCode = "500",
		        		            description = "An unplanned error occurred.",
		        		            content = @Content(mediaType = "application/json")
		        		        )
		        		    }
		        		)
		        		@PutMapping
		        		@ResponseStatus(code = HttpStatus.OK)
		        		User modifyUser(
		        		    @Parameter(
		        		        name = "user_id",
		        		        required = false,
		        		        description = "User ID"
		        		    )
		        		    @PathVariable int user_id,

		        		    @Parameter(
		        		        name = "name",
		        		        description = "Enter the new name"
		        		    )
		        		    @RequestParam(required = false) String name,

		        		    @Parameter(
		        		        name = "email",
		        		        description = "Enter the new email"
		        		    )
		        		    @RequestParam(required = true) String email,

		        		    @Parameter(
		        		        name = "password",
		        		        description = "Enter the new password"
		        		    )
		        		    @RequestParam(required = false) String password
		        		);


		        		@Operation(
		        		    summary = "Deletes a user",
		        		    responses = {
		        		        @ApiResponse(
		        		            responseCode = "204",
		        		            description = "User deleted"
		        		        ),
		        		        @ApiResponse(
		        		            responseCode = "404",
		        		            description = "User not found",
		        		            content = @Content(mediaType = "application/json")
		        		        ),
		        		        @ApiResponse(
		        		            responseCode = "500",
		        		            description = "An unplanned error occurred.",
		        		            content = @Content(mediaType = "application/json")
		        		        )
		        		    },
		        		    parameters = {
		        		        @Parameter(
		        		            name = "user_id",
		        		            allowEmptyValue = false,
		        		            required = true,
		        		            description = "Enter the user ID you would like to delete."
		        		        )
		        		    }
		        		)
		        		@DeleteMapping
		        		@ResponseStatus(code = HttpStatus.OK)
		        		User deleteUser(
		        			      @RequestParam (required = true)
		        			      int user_id);






					
		        		  }



