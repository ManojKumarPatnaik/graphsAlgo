package com.epam.HomeTask.Strings;

import java.util.Scanner;

public class DuplicateCharactersInString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any statement : ");
		String string = scan.nextLine();
		scan.close();
		int count;
		char charArray[] = string.toCharArray();
		System.out.println("Duplicate characters in a given string: ");
		for (int i = 0; i < charArray.length; i++) {
			count = 1;
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j] && charArray[i] != ' ') {
					count++;
					charArray[j] = '0';
				}
			}
			if (count > 1 && charArray[i] != '0') {
				System.out.println(charArray[i]);
			}
		}

	}

}
