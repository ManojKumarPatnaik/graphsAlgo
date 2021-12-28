package com.epam.HomeTask.Arrays;

import java.util.Arrays;
//import java.util.Collections;

public class LargestAndSmallestOfArray {

	public static void main(String[] args) {
		Integer[] number = { 31, 22, 53, 84, 105 };
		Arrays.sort(number);
		int smallest = number[0];
//		Collections.min(Arrays.asList(number));
		int largest = number[number.length - 1];
//		Collections.max(Arrays.asList(number));
		System.out.println("Smallest number of array is : " + smallest);
		System.out.println("Largest number of array is : " + largest);

	}

}