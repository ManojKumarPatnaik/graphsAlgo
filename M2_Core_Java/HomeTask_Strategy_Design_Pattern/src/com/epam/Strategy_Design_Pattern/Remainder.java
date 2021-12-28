package com.epam.Strategy_Design_Pattern;

public class Remainder implements Strategy {

	@Override
	public float calculation(float a, float b) {
		return a % b;
	}
}
