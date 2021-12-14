package com.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myCar")
public class Car {
	
	@Autowired
	private Engine engine; // Engine's object is directly injected here 
	
	private String color;
	
	@Autowired
	private Wheel wheel;
	
/*	public Car() {
		//super();
		System.out.println("Car() constructor..."+this);
	}*/
	
	/* @Autowired
	 public Car(Engine engine) { 
		 super(); this.engine = engine;
	  	System.out.println("Car(Engine) constructor..."+this); 
	 }*/

/*	 public void setEngine(Engine engine) { 
		 this.engine = engine;
		 System.out.println("setEngine(Engine) ..."+this); 
	}*/
	
/*	 public void setColor(String color) { 
		 this.color = color;
		 System.out.println("setColor(String) ..."+this); 
	}
	*/

	/* public void setWheel(Wheel wheel) { 
		 this.wheel= wheel;
		 System.out.println("setWheel(Wheel) ..."+this); 
	}
	 */
	public void startTheCar() {
		engine.ignite();
		System.out.println("Car is started...."+engine);
		System.out.println("Car's wheel...."+wheel);
	}
}
/*
 * 
 * 	DriverManager <-- ClassName
 *  rollNumber		<-- variableName
 *  setLookAndFeel() <-- methodName
 *  pack1.pack2			<-- java.lang
 *  PI, SPEED_OF_LIGHT <-- CONSTANT
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
