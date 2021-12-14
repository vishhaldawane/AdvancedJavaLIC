package com.java;

import org.springframework.stereotype.Component;

@Component
public class Piston {
	private String type;

	public Piston() {
		super();
		//this.type = type;
		System.out.println("Piston() constructor.....");

	}
	
/*	public Piston(String type) {
		super();
		this.type = type;
		System.out.println("Piston(String) constructor.....");

	}
	*/
	public void firePiston() {
		System.out.println("Piston is fired...");
	}
}