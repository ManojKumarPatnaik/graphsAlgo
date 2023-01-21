package com.magadistudio.introclass;


public class JavaClass {

	

	public static void main(String[] args) {
		
		String myString = "Hello";
		
		//Instantiating objects ( creating objects )
		Person myPerson = new Person("Gina", 23, 4);
		Person secondPerson = new Person("Cleusia", 23, 67);
		
		
		//System.out.print("GetClass: " + myPerson.getClass().getSimpleName());
		//System.out.print("Hashcode: " + myPerson.hashCode());
		
//		if (myPerson.equals(secondPerson)) {
//			System.out.println("These two are the same");
//			
//		}else {
//			
//			System.out.println("Not the same objects");
//		}
		
		System.out.println("toString: " + myPerson.toString());
		
		System.out.print(myString);
		
		
		
		
		//myPerson.showData();
		
		
		
		
		
		
		
		
	}

}
