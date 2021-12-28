package com.epam.Strategy_Design_Pattern;

public class Addition implements Strategy {

	@Override
	public float calculation(float a, float b) {
		return a + b;
	}
}
