package com.promineotech.travelplanner.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.travelplanner.entity.Trip;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/trips")
@OpenAPIDefinition(info = @Info(title = "Travel Planner "), servers = {
	    @Server(url = "http://localhost:8080", description = "Localserver.")})
public interface TripController {

	
			@Operation(
			      summary = "Returns all the trips from the user's ID entered",
			      responses = {
			          @ApiResponse(
			        		  responseCode = "200", 
			        		  description = "User and Trips are returned", 
			        		  content = @Content(
			        				  mediaType = "application/json", 
			        				  schema = @Schema(implementation = Trip.class))),
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
			    		          @Parameter(name = "user_id", allowEmptyValue = false, required = false,
											description = "Enter the user ID")
			    		        		  
			      }
			    		              )
			    		          
			      
			     
			      
			  		@GetMapping
			        @ResponseStatus(code = HttpStatus.OK)

			          List<Trip> fetchTripById(@RequestParam(required = false, name = "user_id")
			          int user_id);
			       
			          

			          @Operation(
			        		    summary = "Adds a trip to an exisiting user",
			        		    responses = {
			        		        @ApiResponse(
			        		            responseCode = "201",
			        		            description = "Trip added to the user's trips",
			        		            content = @Content(
			        		                mediaType = "application/json",
			        		                schema = @Schema(implementation = Trip.class)
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
			        		Trip createTrip(
			        				
			        			
			        		    @Parameter(
			        		        name = "trip_id",
			        		        allowEmptyValue = false,
			        		        required = true,
			        		        description = "Trip ID"
			        		    )
	 		        		    @PathVariable int trip_id,

			        		    @Parameter(
			        		        name = "destination",
			        		        allowEmptyValue = false,
			        		        required = true,
			        		        description = "Destination"
			        		    )
			        		    @RequestParam String destination,

			        		    @Parameter(
			        		        name = "startDate",
			        		        allowEmptyValue = false,
			        		        required = true,
			        		        description = "Start Date"
			        		    )
			        		    @RequestParam Date startDate,

			        		    @Parameter(
			        		        name = "endDate",
			        		        allowEmptyValue = false,
			        		        required = true,
			        		        description = "End Date"
			        		    )
			        		    @RequestParam Date endDate,
			        		    
			        		    
			        		    @Parameter(
				 		        		 name = "user_id_fk",
				 		        		 allowEmptyValue = false,
				 		        		 required = true,
				 		        		 description = "User ID"
				 		        		    )
				 		        		    @PathVariable int user_id

			        		);
}