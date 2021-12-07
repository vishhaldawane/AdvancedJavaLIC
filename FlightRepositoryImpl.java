package com.java.layer3;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.java.layer2.Flight;

public class FlightRepositoryImpl implements FlightRepository {

	List<Flight> flightList = new ArrayList<Flight>();//empty list
	
	public FlightRepositoryImpl() {
		System.out.println("FlightRepositoryImpl() constructor....");
		Flight flight1 = new Flight(101,"Mumbai","London", Timestamp.valueOf("2021-12-24 23:45:00"));
		Flight flight2 = new Flight(102,"Mumbai","London", Timestamp.valueOf("2021-12-23 13:15:00"));
		Flight flight3 = new Flight(103,"Mumbai","London", Timestamp.valueOf("2021-12-21 13:35:00"));
		
		Flight flight4 = new Flight(104,"Mumbai","Paris", Timestamp.valueOf("2021-12-24 23:45:00"));
		Flight flight5 = new Flight(105,"Mumbai","Paris", Timestamp.valueOf("2021-12-24 14:15:00"));
		
		Flight flight6 = new Flight(106,"Mumbai","New York", Timestamp.valueOf("2021-12-22 20:45:00"));
		Flight flight7 = new Flight(107,"Mumbai","New York", Timestamp.valueOf("2021-12-22 18:15:00"));
		
		Flight flight8 = new Flight(108,"Mumbai","Germany", Timestamp.valueOf("2021-12-21 02:25:00"));
		
		Flight flight9 = new Flight(109,"Mumbai","Netherlands", Timestamp.valueOf("2021-12-25 08:45:00"));
		Flight flight10 = new Flight(110,"Mumbai","Netherlands", Timestamp.valueOf("2021-12-25 06:23:00"));
		
		Flight flight11 = new Flight(111,"Mumbai","New Zealand", Timestamp.valueOf("2021-12-26 23:55:00"));
		Flight flight12 = new Flight(112,"Mumbai","New Zealand", Timestamp.valueOf("2021-12-27 12:15:00"));
		
		flightList.add(flight1);flightList.add(flight2);
		flightList.add(flight3);flightList.add(flight4);
		flightList.add(flight5);flightList.add(flight6);
		flightList.add(flight7);flightList.add(flight8);
		flightList.add(flight9);flightList.add(flight10);
		flightList.add(flight11);flightList.add(flight12);
	
	}
	@Override
	public void insertFlight(Flight flight) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFlight(Flight flight) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFlight(int flightNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public Flight searchFlight(int flightNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> searchFlights() {
		
		return flightList;
	}
	@Override
	public List<Flight> searchFlights(String source, String target) {
		
		List<Flight> foundFlights = new ArrayList<Flight>();
		
		for(Flight theFlight : flightList) {
			if(theFlight.getFlightSource().equalsIgnoreCase(source) && theFlight.getFlightDestination().equals(target)) {
				foundFlights.add(theFlight);
			}
		}
		return foundFlights;
	}

}
