package com.epam.HomeTask.lambda;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class StringRotation  {
//	static boolean areRotations(String str1, String str2) {
//		return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
//	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		scan.close();
		//Without Using lambda expressions 
//		if (areRotations(str1, str2))
//			System.out.println("Strings are rotations of each other without using lambda expression");
//		else
//			System.out.printf("Strings are not rotations of each other without using lambda expression");
		//Using lambda expressions 
		BiPredicate<String,String> bipredicate=(strn1,strn2)->(strn1.length() == strn2.length()) && ((strn1 + strn1).indexOf(strn2) != -1);
		if(bipredicate.test(str1,str2)) 
			System.out.println("Strings are rotations of each other with using lambda expression");
		else
			System.out.printf("Strings are not rotations of each other with using lambda expression");
	}

}
