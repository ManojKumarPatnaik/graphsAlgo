package com.epam.HomeTask.lambda;

import java.util.*;

public class StringPalindrome {

	public static void Withoutlambda(String OriginalString, String ReverseString) {

		if (OriginalString.equals(ReverseString)) {
			System.out.println("The Given String is Palindrome");
		} else
			System.out.println("The Given String is not a Palindrome");

	}

	public static void main(String[] args) {
		String OriginalString, ReverseString = "";
		Scanner scan = new Scanner(System.in);
		OriginalString = scan.nextLine();
		for (int i = OriginalString.length() - 1; i >= 0; i--) {
			ReverseString += OriginalString.charAt(i);
		}
		scan.close();
		Withoutlambda(OriginalString, ReverseString);
	}

}