package com.epam.HomeTask.Loops;

import java.util.Scanner;

public class PyramidPatternUsingDo_While {

	public static void main(String[] args) {
		int startingNumber = 0, i = 0, j = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number:");
		int number = scanner.nextInt();
		System.out.println("Enter X:");
		int increment = scanner.nextInt();
		scanner.close();
		do {
			do {
				System.out.print(startingNumber + "	");
				startingNumber += increment;
				j++;
			} while (j <= i);
			System.out.println();
			i++;
			j = 0;
		} while (i < number);

	}

}
