package com.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myPiston")
public class Piston {
	private String type;

	/*
	public Piston() {
		super();
		//this.type = type;
		System.out.println("Piston() constructor.....");

	}*/
	
	@Autowired
	public Piston(@Value("TwinSpark") String type) {
		super();
		this.type = type;
		System.out.println("Piston(String) constructor....."+type);
	}
	
	public void firePiston() {
		System.out.println("Piston is fired...");
	}
}