package com.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myEngine")
public class Engine {
	private Piston piston;

/*	public Engine() {
		super();
		System.out.println("Engine() constructor...");
	}*/
	
	@Autowired
	public Engine(Piston piston) {
		super();
		this.piston = piston;
		System.out.println("Engine(Piston) constructor..."+this);
	}
	
	public void ignite() {
		piston.firePiston();
		System.out.println("Engine is ignited...");
	}
}