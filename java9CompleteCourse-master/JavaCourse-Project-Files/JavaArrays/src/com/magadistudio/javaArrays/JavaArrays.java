package com.magadistudio.javaArrays;

import java.util.Arrays;

public class JavaArrays {

	public static void main(String[] args) {

		//Arrays
		int[] arrInts = {4, 2, 8, 5 };
		String[] arrStrings = {"Johna", "Arao", "Ines", "Olga", "Fina" };
		boolean[] arrBools = {true, false, true, false};
		
		int[] newArray = new int[4];
		
		newArray[0] = 12;
		newArray[1] = 13;
		newArray[2] = 45;
		newArray[3] = 23;
		
	
		
		  Arrays.sort(arrInts);
//		
		
		for (int i = 0; i < arrInts.length; i++) {
			
			System.out.println("Sorted #:" + arrInts[i]);
			
		}
		
	  for (int i = 0; i < arrStrings.length; i++) {
			
			System.out.println("My Siblings Before sorting : " + arrStrings[i]);
			System.out.println("----========-------");
			
		}
	  
	  Arrays.sort(arrStrings);
	  
		for (int i = 0; i < arrStrings.length; i++) {
			
			System.out.println("My Siblings After Sorting: " + arrStrings[i]);
			
		}
		
//		for (int i = 0; i < arrBools.length; i++) {
//			
//			System.out.println("Output: " + arrBools[i]);
//			
//		}
//		
		
	}

}
