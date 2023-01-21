package com.magadistudio.introclass;


/*
 * 
 * public --> can be tempered with outside the class
 * 
 * private --> only used within the class in which it's defined.
 * 
 * protected --> within the same package and/or derived classes
 */

public class Person {

	
	//Instance variables or properties ( states or fields )
	private String name;
	private int age;
	private int height;

	
	//Constructor
	public Person() {
		
	}
	
	//Overloading Constructors
	public Person(String myName) {
		name = myName;
	}
	
	public Person(String myName, int myAge) {
		
		name = myName;
		age = myAge;
	}
	
	public Person(String myName, int myAge, int myHeight) {
		name = myName;
		age = myAge;
		height = myHeight;
	}

	
//	
//	public void setName(String myName) {
//		
//		name = myName;
//		
//	}
//	
//	public void setAge(int myAge) {
//		
//		age = myAge;
//		
//	}
//	
//	public void setHeight(int myHeight) {
//		
//		height = myHeight;
//	}
	
	
	//Getters
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
	
	//Behaviors == functions
	public void showData() {
		
		System.out.println("Name is " + getName() + ", " + getAge() + ", " + getHeight() );
	}

	
}
