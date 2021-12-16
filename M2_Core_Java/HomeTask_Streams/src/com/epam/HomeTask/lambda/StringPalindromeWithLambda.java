package com.epam.HomeTask.lambda;

import java.util.Scanner;

@FunctionalInterface
interface lambda {
	public void withLambda(String OriginalStr, String ReverseStr);
}

public class StringPalindromeWithLambda {

	public static void main(String[] args) {
		String OriginalString, ReverseString = "";
		Scanner scan = new Scanner(System.in);
		OriginalString = scan.nextLine();
		scan.close();
		for (int i = OriginalString.length() - 1; i >= 0; i--) {
			ReverseString += OriginalString.charAt(i);
		}
		lambda obj = (OriginalStr, ReverseStr) -> {
			if (OriginalStr.equals(ReverseStr)) {
				System.out.println("The Given String is Palindrome by using Lambda Expression");
			} else
				System.out.println("The Given String is not a Palindrome by using Lambda Expression");
		};
		obj.withLambda(OriginalString, ReverseString);

	}

}
