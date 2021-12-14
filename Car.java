package com.java;

public class Car {
	private Engine engine;
	private Wheel wheel;

	/*public Car() {
		System.out.println("Car() constructor..."+this);
	}*/
	/*
	 * public Car(Engine engine) { super(); this.engine = engine;
	 * System.out.println("Car(Engine) constructor..."+this); }
	 */
	

	 public void setEngine(Engine engine) { 
		 this.engine = engine;
		 System.out.println("setEngine(Engine) ..."+this); 
	}
	 

	 public void setWheel(Wheel wheel) { 
		 this.wheel= wheel;
		 System.out.println("setWheel(Wheel) ..."+this); 
	}
	 
	public void startTheCar() {
		engine.ignite();
		System.out.println("Car is started....");
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
