package com.java.layer3;

import java.util.List;

import com.java.layer2.Flight;

public interface FlightRepository {

	//C-R-RA-U-D
	
	void insertFlight(Flight flight); //C
	void updateFlight(Flight flight); // U
	void deleteFlight(int flightNumber); // D
	Flight searchFlight(int flightNumber); //R
	List<Flight> searchFlights(); //java.util  //RA
	
}
