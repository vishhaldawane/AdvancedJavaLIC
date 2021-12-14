package com.java;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private Piston piston;

	public Engine() {
		super();
		System.out.println("Engine() constructor...");
	}
	
	/*public Engine(Piston piston) {
		super();
		this.piston = piston;
		System.out.println("Engine(Piston) constructor...");
	}
	*/
	public void ignite() {
		piston.firePiston();
		System.out.println("Engine is ignited...");
	}
}