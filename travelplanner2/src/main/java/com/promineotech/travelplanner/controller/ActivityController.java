package com.promineotech.travelplanner.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.travelplanner.entity.Activity;
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
@RequestMapping("/activities")
@OpenAPIDefinition(info = @Info(title = "Travel Planner - Activities"), servers = {
	    @Server(url = "http://localhost:8080", description = "Localserver.")})
@RestController
public interface ActivityController {
	
	
	  

	//gets an activity by ID

		@Operation(
		      summary = "Get activity by ID",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		        		  description = "Activity found", 
		        		  content = @Content(mediaType = "application/json", 
		        		  schema = @Schema(implementation = Activity.class))),
		          @ApiResponse(responseCode = "400", 
		          		description = "Invalid request", 
		          		content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404",
		          		description = "Activity not found", 
		          		content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500",
		          		description = "An unplanned error occurred.", 
				         content = @Content(mediaType = "application/json"))

		      }
		      )
		  		@GetMapping
				@ResponseStatus(code = HttpStatus.OK)

		List<Activity> fetchActivityById(@RequestParam(required = true)
		int activity_id);		
	
		 
			// Define a method to create a new activity

		     
		          @Operation(
		        		  	summary = "Create a new activity",
		        		  	responses = {

		          @ApiResponse(
		        		  responseCode = "201", 
		        		  description = "Activity created",
		                  content = @Content(mediaType = "application/json",
				          schema = @Schema(implementation = Activity.class))),

		          @ApiResponse(
		        		  responseCode = "500",
		        		  description = "An unplanned error occurred.", 
		        		  content = @Content(mediaType = "application/json"))
		        		  }
		        		  )
		        		  	
		          
		          @PostMapping
		          @ResponseStatus(code = HttpStatus.CREATED)
	        		Activity createActivity(
	        				
	       

	        		    @Parameter(
	        		        name = "name",
	        		        allowEmptyValue = false,
	        		        required = true,
	        		        description = "Activity name"
	        		    )
	        		    @RequestParam String name,

	        		    @Parameter(
	        		        name = "description",
	        		        allowEmptyValue = true,
	        		        required = false,
	        		        description = "description"
	        		    )
	        		    @RequestParam String description,

	        		    @Parameter(
	        		        name = "location",
	        		        allowEmptyValue = false,
	        		        required = true,
	        		        description = "Activity location"
	        		    )
	        		    @RequestParam String location
	        		);
		        
		          
		      
		          }
		         



