package com.java.layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.java.layer2.Flight;

public class FlightRepositoryImpl2 implements FlightRepository {

	List<Flight> flightList = new ArrayList<Flight>();//empty list
	
	Connection conn;
	
	public FlightRepositoryImpl2() {
		System.out.println("FlightRepositoryImpl2() constructor....");
		try {
			//1
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver registered....");
			
			//2
			this.conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"system","tiger");
			System.out.println("Connected to the DB : "+conn); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	@Override
	public void insertFlight(Flight flight) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into flight_details values (?,?,?,?)");
			pst.setInt(1, flight.getFlightNumber());
			pst.setString(2, flight.getFlightSource());
			pst.setString(3, flight.getFlightDestination());
		//	pst.setTimestamp(4, flight.getFlightDepartureDate());
			int rows = pst.executeUpdate(); // fire the query
			System.out.println("Flight Record inserted...."+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateFlight(Flight flight) {
		try {
			PreparedStatement pst = conn.prepareStatement("update flight_details set source=?, target=?, departure=? where flno=?");
			pst.setInt(4, flight.getFlightNumber());
			
			pst.setString(1, flight.getFlightSource());
			pst.setString(2, flight.getFlightDestination());
		//	pst.setDate(3, flight.getFlightDepartureDate());

			int rows = pst.executeUpdate(); // fire the query
			System.out.println("Flight Record updated...."+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteFlight(int flightNumber) {
		try {
			PreparedStatement pst = conn.prepareStatement("delete from flight_details where flno=?");
			pst.setInt(1, flightNumber);
			int rows = pst.executeUpdate(); // fire the query
			System.out.println("Flight Record deleted...."+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Flight searchFlight(int flightNumber) {
		
		Flight flightObj = null;
		try {
	//3
			Statement statement = conn.createStatement();
			System.out.println("statement created..."+statement);
			
			ResultSet result = statement.executeQuery("select * from flight_details where flno="+flightNumber);
			System.out.println("Got the result set : "+result);
	
			if(result.next()) {
				flightObj = new Flight();
				flightObj.setFlightNumber(result.getInt(1));
				flightObj.setFlightSource(result.getString(2));
				flightObj.setFlightDestination(result.getString(3));
				java.sql.Date sqlDate = result.getDate(4);
				long millis = sqlDate.getTime();
				
				LocalDate localDate = LocalDate.ofEpochDay(millis);
				
						//LocalDate.of(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.)
				flightObj.setFlightDepartureDate(localDate);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightObj;
	}

	@Override
	public List<Flight> searchFlights() {
		
		Flight flightObj = null;
		try {
	//3
			Statement statement = conn.createStatement();
			System.out.println("statement created..."+statement);
			
			ResultSet result = statement.executeQuery("select * from flight_details");
			System.out.println("Got the result set : "+result);
	
			while(result.next()) {
				flightObj = new Flight();
				flightObj.setFlightNumber(result.getInt(1));
				flightObj.setFlightSource(result.getString(2));
				flightObj.setFlightDestination(result.getString(3));
				//flightObj.setFlightDepartureDate(result.getTimestamp(4));
				flightList.add(flightObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightList;
	}
	@Override
	public List<Flight> searchFlights(String source, String target) {
		
		List<Flight> foundFlights = new ArrayList<Flight>();
		
		Flight flightObj = null;
		try {
	//3
			Statement statement = conn.createStatement();
			System.out.println("statement created..."+statement);
			
			ResultSet result = statement.executeQuery("select * from flight_details where source="+"'"+source+"'"+" and target="+"'"+target+"'"); //select * from flight_details where source='mumbai' and target='delhi'  
			System.out.println("Got the result set : "+result);
	
			while(result.next()) {
				flightObj = new Flight();
				flightObj.setFlightNumber(result.getInt(1));
				flightObj.setFlightSource(result.getString(2));
				flightObj.setFlightDestination(result.getString(3));
			
				java.sql.Date sqlDate = result.getDate(4);
				System.out.println("sql date "+sqlDate);
				
				long millis = sqlDate.getTime();
				Date date = new Date(millis);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				
				LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
				System.out.println("local date "+localDate);
				
				flightObj.setFlightDepartureDate(localDate);
				foundFlights.add(flightObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundFlights;
	
	}
	
	@Override
	public List<Flight> searchFlights(String source, String target, LocalDate when) {
		
		List<Flight> foundFlights = new ArrayList<Flight>();
		
		Flight flightObj = null;
		try {
	//3
			Statement statement = conn.createStatement();
			System.out.println("statement created..."+statement);
			
			String dateString = when.toString();
			
			String query = "select * from flight_details where source="+"'"+source+"'"+" and target="+"'"+target+"'"+" and to_char(departure,'yyyy-MM-dd') ="+"'"+  dateString +"'";
			System.out.println("query "+query);
			ResultSet result = statement.executeQuery(query);  
			 
			System.out.println("Got the result set : "+result);
	
			while(result.next()) {
				flightObj = new Flight();
				flightObj.setFlightNumber(result.getInt(1));
				flightObj.setFlightSource(result.getString(2));
				flightObj.setFlightDestination(result.getString(3));
			
				java.sql.Date sqlDate = result.getDate(4);
				System.out.println("sql date "+sqlDate);
				
				long millis = sqlDate.getTime();
				Date date = new Date(millis);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				
				LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
				System.out.println("local date "+localDate);
				
				flightObj.setFlightDepartureDate(localDate);
				foundFlights.add(flightObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundFlights;
	
	}

}
