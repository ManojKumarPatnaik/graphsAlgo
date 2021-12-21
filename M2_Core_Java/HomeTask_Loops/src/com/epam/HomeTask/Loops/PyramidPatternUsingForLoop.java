package com.epam.HomeTask.Loops;

import java.util.Scanner;

public class PyramidPatternUsingForLoop {

	public static void main(String[] args) {
		int startingNumber = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number:");
		int number = scanner.nextInt();
		System.out.println("Enter X:");
		int increment = scanner.nextInt();
		scanner.close();
		for (int i = 0; i < number; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(startingNumber + "	");
				startingNumber += increment;
			}
			System.out.println();
		}

	}

}
