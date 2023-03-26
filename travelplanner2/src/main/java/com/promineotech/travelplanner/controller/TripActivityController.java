package com.promineotech.travelplanner.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.travelplanner.entity.TripActivity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/tripactivities")
@OpenAPIDefinition(info = @Info(title = "The activities in trips"), servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface TripActivityController {
	@Operation(
		      summary = "Returns all the activities in a trip",
		      responses = {
		          @ApiResponse(
		        		  responseCode = "200", 
		        		  description = "Trip and activities are returned", 
		        		  content = @Content(
		        				  mediaType = "application/json", 
		        				  schema = @Schema(implementation = TripActivity.class))),
		          @ApiResponse(responseCode = "400", 
		          		description = "Invalid request", 
		          		content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404",
		          		description = "No trips were found", 
		          		content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500",
		          		description = "An unplanned error occurred.", 
				         content = @Content(mediaType = "application/json"))

		      },

		    		  parameters = {
		    		          @Parameter(name = "trip_id", allowEmptyValue = false, required = false,
										description = "Enter the trip ID")
		    		        		  
		      }
		    		              )
		     
		      
		  		@GetMapping
		        @ResponseStatus(code = HttpStatus.OK)

		          List<TripActivity> fetchActivityinTripbyId(@RequestParam(required = false, name = "trip_id")
		          int trip_id);
		       
		          

		          @Operation(
		        		    summary = "Adds a activity to an exisiting trip",
		        		    responses = {
		        		        @ApiResponse(
		        		            responseCode = "201",
		        		            description = "Activity added to trip",
		        		            content = @Content(
		        		                mediaType = "application/json",
		        		                schema = @Schema(implementation = TripActivity.class)
		        		            )
		        		        ),
		        		        @ApiResponse(
		        		            responseCode = "500",
		        		            description = "An unplanned error occurred.",
		        		            content = @Content(mediaType = "application/json")
		        		        )
		        		
		        	
						},

		        		    parameters = {
		        		    		@Parameter(name = "trip_id", allowEmptyValue = false, required = false,
		        		    				description = "Existing trip ID"),
		
		        		    		@Parameter(name = "activity_id", allowEmptyValue = false, required = false,
		        		    		description = "Add activity ID."),
		        		    }	
		        		  )
		          @PutMapping
		          @ResponseStatus(code = HttpStatus.CREATED)
		          TripActivity addActivityToTrip(
	

		        		 @RequestParam(required = false) int trip_id,
		        		 @RequestParam(required = true) int activity_id);
		          
}
