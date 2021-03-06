package com.java.layer5;

import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.layer2.Flight;
import com.java.layer3.FlightRepositoryImpl;
import com.java.layer3.FlightRepositoryImpl2;

public class FlightEnquiryServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	FlightRepositoryImpl2 flightRepo = new FlightRepositoryImpl2();
	
    
    public FlightEnquiryServlet2() {
        super();
        System.out.println("FlightEnquiryServlet2().constructor.......");
		
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("\tinit().....");
		
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("\tdestroy().....");
		
	}

	//controller activity
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		System.out.println("doGet()....."
					+request.getRemoteAddr()
					+" port "+request.getRemotePort());
		String source= request.getParameter("src");
		String target= request.getParameter("trg");
		
		String dateString =	request.getParameter("jdate");
		CharSequence  charSeq = dateString.subSequence(0, dateString.length());
		
		LocalDate when = LocalDate.parse(charSeq);
		
		System.out.println("dateString : "+dateString);

				
		//ctrl+shift+m
		PrintWriter pw = response.getWriter();
		pw.println("Customer is searching for "
		+source+" to "+target+" flight");
		
	//Model data 
		//1 by default below object is on this page
		List<Flight> foundFlights = flightRepo.searchFlights(source, target, when);

		//2 - request tracking...
		request.setAttribute("ffkey1", foundFlights);
	
		RequestDispatcher rd = request.getRequestDispatcher("ShowAvailableFlights.jsp");
		rd.forward(request, response);
		
		//3 - Session tracking
		//HttpSession session = request.getSession(true);
		//session.setAttribute("ffkey2",foundFlights);
		
		//4 - Application's context
		//ServletContext ctx = getServletContext();
		//ctx.setAttribute("ffkey3", foundFlights);
		
	//VIEW
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()..when?...");
		
		doGet(request, response);
	}

}
