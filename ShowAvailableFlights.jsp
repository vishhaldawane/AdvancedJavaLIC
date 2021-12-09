<%@page import="java.util.List"%>
<%@page import="com.java.layer2.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Shown by the JSP Page </h1>
<%	List<Flight> foundFlights =	(List<Flight>) request.getAttribute("ffkey1"); %>

<table border=3 cellspacing=5 cellpadding=5>
		
		<% for(Flight theFlight : foundFlights) {%>
		
				<tr>
				<td><%=theFlight.getFlightNumber()%></td>
				<td><%=theFlight.getFlightSource()%></td>
				<td><%=theFlight.getFlightDestination()%></td>
				<td><%=theFlight.getFlightDepartureDate()%></td>
				</tr>
		
		<%} %>
		
		</table>
		<a href='http://localhost:8080/MyAirlineApp'> Back </a>
		
</body>
</html>