package com.epam.HomeTask.Basics;

import java.util.Scanner;

public class DisplayName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your name : ");
		String name=scan.next();
		scan.close();
		System.out.println("Hello, "+name);

	}

}
