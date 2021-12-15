package com.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.entity.Flight;
import com.repo.FlightRepository;
import com.repo.exceptions.FlightAlreadyPresentException;
import com.repo.exceptions.FlightNotFoundException;
@ExtendWith(SpringExtension.class) 
@ContextConfiguration(locations = {"classpath:SpringConfig3.xml"}) //copied in src/main/resources
public class FlightCrudTestCases {

	@Autowired
	@Qualifier("flightRepoImpl3")
	FlightRepository flightRepo ;
	
	@Test
	public void updateFlightTest() {
		
		Flight newFlight = new Flight();
		newFlight.setFlightNumber(101); //existing number
		newFlight.setSource("MUMBAI"); //current value is mumbai
		newFlight.setDestination("New York"); //current val
		flightRepo.updateFlight(newFlight);
		
	}
	//drop the flights table, and run below test case
	@Test
	public void addNewFlight() {
		Flight newFlight = new Flight();
		newFlight.setFlightNumber(104);
		newFlight.setSource("Mumbai");
		newFlight.setDestination("AbuDhabi");
		newFlight.setDepartureDate(LocalDate.of(2021, 12, 29));
		try {
			flightRepo.insertFlight(newFlight);
		} catch (FlightAlreadyPresentException e) {
			System.out.println("Problem : "+e.getMessage());
		//	e.printStackTrace();
		}
	}
	
	@Test
	public void searchFlightTest()
	{
		LocalDateTime when = LocalDateTime.of(2021, 12, 29, 21, 45);
		
		try {
			List<Flight> flightList = flightRepo.getAvailableFlights("Mumbai", "New York", when);
		Assertions.assertNotNull(flightList);
			for(Flight theFlight : flightList) {
					System.out.println("Flight Number : "+theFlight.getFlightNumber());
					System.out.println("Flight Source : "+theFlight.getSource());
					System.out.println("Flight Destin : "+theFlight.getDestination());
					System.out.println("Flight Date   : "+theFlight.getDepartureDate());					
					System.out.println("-------------------");
			}
			
		} catch (FlightNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem : "+e.getMessage());	
			
		}
		
	}

}


