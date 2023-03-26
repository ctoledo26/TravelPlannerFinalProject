package com.promineotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.travelplanner.ComponenScanMarker;

@SpringBootApplication (scanBasePackageClasses = {ComponenScanMarker.class})

public class travelPlanner {

	public static void main(String[] args) {

		SpringApplication.run(travelPlanner.class, args);
	}

}
