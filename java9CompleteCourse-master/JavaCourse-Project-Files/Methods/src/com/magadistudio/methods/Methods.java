package com.magadistudio.methods;

import java.util.Scanner;

public class Methods {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String myName = "";
		
	
		
		//System.out.println("Enter Your name:");
		
		//myName = scanner.next();
		
		
		
		//call our method
		//showName(myName);
		//addNumbers(6, 6);
		
	    int area = getArea(10, 10) + 23 - 4;
		
		
		//System.out.println(" The area is : " + area);
	    
	    
	    //System.out.print("Full name is: " + fullName("Paulo", "Dichone") + " Hello ");
		
	    System.out.println("My Truth: " + isTrue(true, true));
	    
		
		//scanner.close();
		
	}
	
	public static int getArea(int width, int height) {
		
		return width * height;
		
	}
	
	public static String fullName(String firstname, String lastname) {
		
		return firstname + " " + lastname;
	}
	
	public static boolean isTrue(boolean a, boolean b) {
		
		if (a != b) {
			return a;
		}else{
			return b;
		}
		
	
	}
	
	
	public static void addNumbers(int a, int b) {
		
		System.out.println(a+b);
		
	}
	
	
	
	public static void showName(String name) {
		
		System.out.print("My name is " + name );
		
	}

}
