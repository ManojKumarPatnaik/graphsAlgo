package com.epam.Singleton_Design_Pattern;

public class Main {

	public static void main(String[] args) {
		Singleton singletonObject1 = Singleton.getInstance();
		Singleton singletonObject2 = Singleton.getInstance();
		System.out.println("Hashcode of singletonObject1 is "+singletonObject1.hashCode());
		System.out.println("Hashcode of singletonObject2 is "+singletonObject2.hashCode());
		singletonObject1.displayMessage();
		singletonObject2.displayMessage();
		if (singletonObject1 == singletonObject2) {
			System.out.println("Two objects point to the same memory location on the heap i.e, to the same object");
		} else {
			System.out.println("Three objects DO NOT point to the same memory location on the heap");
		}
	}
}
