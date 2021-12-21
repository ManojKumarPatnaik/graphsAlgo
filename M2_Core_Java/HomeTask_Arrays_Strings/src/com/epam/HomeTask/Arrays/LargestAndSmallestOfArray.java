package com.epam.HomeTask.Arrays;

import java.util.Arrays;
import java.util.Collections;

public class LargestAndSmallestOfArray {

	public static void main(String[] args) {
		Integer[] number = { 31, 22, 53, 84, 105 };
		int smallest = Collections.min(Arrays.asList(number));
		int largest = Collections.max(Arrays.asList(number));
		System.out.println("Smallest number of array is : " + smallest);
		System.out.println("Largest number of array is : " + largest);

	}

}