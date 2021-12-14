package com.java;

import org.springframework.stereotype.Component;

@Component("myWheel")
public class Wheel {

	public Wheel() {
		System.out.println("Wheel() constructor..."+this);
	}
}
