package com.java;

public class Piston {
	private String type;

	public Piston(String type) {
		super();
		this.type = type;
		System.out.println("Piston constructor.....");

	}
	
	public void firePiston() {
		System.out.println("Piston is fired...");
	}
}