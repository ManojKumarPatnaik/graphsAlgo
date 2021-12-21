package com.epam.HomeTask.Basics;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		int number1,number2;
		char operator;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first number : ");
		number1=scan.nextInt();
		System.out.println("Enter the second number : ");
		number2=scan.nextInt();
		System.out.println("Enter the operator : ");
		operator=scan.next().charAt(0);
		scan.close();
		if(operator=='+') {
			System.out.println("Addition of two numbers = "+(number1+number2));
		}else if(operator=='-') {
			System.out.println("Subtraction of two numbers = "+(number1-number2));
		}else if(operator=='*') {
			System.out.println("Multiplication of two numbers = "+(number1*number2));
		}else if(operator=='/') {
			System.out.println("Division of two numbers = "+(number1/number2));
		}else if(operator=='%') {
			System.out.println("Reminder of two numbers = "+(number1%number2));
		}else {
			System.out.println("Invalid operator");
		}
		float percentage=(float)number1/number2;
		System.out.println("Percentage of two numbers = "+percentage);
	}

}
