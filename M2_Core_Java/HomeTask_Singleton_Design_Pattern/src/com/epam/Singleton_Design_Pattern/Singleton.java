package com.epam.Singleton_Design_Pattern;

public class Singleton {
	private static Singleton singletonObject;

	private Singleton() {

	}

	@SuppressWarnings("unused")
	static Singleton getInstance() {
		if (singletonObject == null) {
			singletonObject = new Singleton();
		}
		return singletonObject;
	}
	public void displayMessage() {
		System.out.println("I have called using Singleton Object");
	}
}
