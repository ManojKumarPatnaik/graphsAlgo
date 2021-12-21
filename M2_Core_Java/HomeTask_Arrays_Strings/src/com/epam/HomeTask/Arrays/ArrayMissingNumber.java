package com.epam.HomeTask.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMissingNumber {
	public static int getMissingNumber(int[] arr) {
		int n = arr.length;
		int m = n + 1;
		int total = m * (m + 1) / 2;
		int sum = Arrays.stream(arr).sum();
		int result = total - sum;
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of an array");
		int size = scan.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = scan.nextInt();
		}
		scan.close();
		System.out.println("The Missing Number in the given array = " + getMissingNumber(array));

	}

}
