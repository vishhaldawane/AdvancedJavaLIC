package com.java.layer2;

import java.sql.Timestamp;
//Flight f = new Flight(101,"mumbai","London","time");

public class Flight {
	
	private int flightNumber;
	private String flightSource;
	private String flightDestination;
	private Timestamp flightDepartureDate; //java.sql
	
	public Flight(int flightNumber, String flightSource, String flightDestination, Timestamp flightDepartureDate) {
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

	public Timestamp getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(Timestamp flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}
	
	
}
