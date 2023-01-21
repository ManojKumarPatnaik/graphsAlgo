package com.magadistudio.MeterToFeet;

import java.util.Scanner;

public class MetersToFeet {

	public static void main(String[] args) {
		
		/**
		 *  1m = 3.28 feet
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		
		double multiplier = 3.28;
		
		System.out.println("Please enter Meters: ");
		
		double meterVal = scan.nextDouble();
		
		double result = multiplier * meterVal;
		
		System.out.println(meterVal + " meters is " + result + " feet ");
		
		scan.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//
//		 double multiplier = 3.28;
//		 
//		 double result = 0;
//		 double metersVal = 234;
//		 
//		 result = multiplier * metersVal;
//		 
//		 System.out.println(metersVal + " meters is " + result +" feet ");
	 
		
		 
		 
	}

}
