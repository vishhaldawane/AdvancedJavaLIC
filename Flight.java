package com.java.layer2;

import java.sql.Timestamp;
import java.time.LocalDate;
//Flight f = new Flight(101,"mumbai","London","time");

public class Flight {
	
	private int flightNumber;
	private String flightSource;
	private String flightDestination;
	private LocalDate flightDepartureDate; //java.sql
	
	public Flight() {
		System.out.println("Flight() no arg constructor....");
	}
	public Flight(int flightNumber, String flightSource, String flightDestination, LocalDate flightDepartureDate) {
		super();
		this.flightNumber = flightNumber;
		this.flightSource = flightSource;
		this.flightDestination = flightDestination;
		this.flightDepartureDate = flightDepartureDate;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightSource() {
		return flightSource;
	}

	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public LocalDate getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(LocalDate flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}
	
	
}
