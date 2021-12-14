package com.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {
	public static void main(String[] args) {
	
		System.out.println("Loading the spring container...");
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfig.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringAnnoConfig.xml");
		
		
		//singleton instance - FlightEnquiry - List getAvailableFlights(s,t,dt)
		//prototype
		System.out.println("Loaded the spring container...");
		
	
		Car theCar1 = (Car) ctx.getBean("myCar");
		theCar1.startTheCar();
		
	/*	
		Car theCar2 = (Car) ctx.getBean("myCar");
		theCar2.startTheCar();
		
		Car theCar3 = (Car) ctx.getBean("myCar");
		theCar3.startTheCar();
		
		System.out.println("theCar1 "+theCar1);
		System.out.println("theCar2 "+theCar2);
		System.out.println("theCar3 "+theCar3);
		*/
		
		System.out.println();
	}
}
/*
				FlightEnquiry fe1 = ctx.getBean("flightEnq"); - getAvailableFlights(s,t,dt)
				|			fe2 = ctx.getBean("flightEnq");
		 Server	|			 |			fe3 = ctx.getBean("flightEnq");
		 	|	|			 |			|
			|	p1(s1+t1)   p2(s2+t2)  p3(s3+t3)
			|
---------------------------
|			|			|
s1			s2			s3
browser		mobileapp	telephonicEnquiry	




*/





