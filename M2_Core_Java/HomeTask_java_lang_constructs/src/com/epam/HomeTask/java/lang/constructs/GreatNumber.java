package com.epam.HomeTask.java.lang.constructs;

import java.util.Scanner;

public class GreatNumber {
	public static boolean GreatNumber6(int a, int b) {
		return (a==6||b==6||a+b==6||Math.abs(a-b)==6);
		
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int number1=scan.nextInt();
		int number2=scan.nextInt();
		scan.close();
		GreatNumber6(number1, number2);
		
	}

}
