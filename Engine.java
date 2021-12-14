package com.java;

public class Engine {
	private Piston piston;

	public Engine(Piston piston) {
		super();
		this.piston = piston;
		System.out.println("Engine constructor...");
	}
	
	public void ignite() {
		piston.firePiston();
		System.out.println("Engine is ignited...");
	}
}