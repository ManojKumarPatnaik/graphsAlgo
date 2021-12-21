package com.epam.HomeTask.java.lang.constructs;

public class SumLimit {
	public static int sumLimit(int a, int b) {
		  if (String.valueOf(a+b).length() == String.valueOf(a).length()) return a + b;
		  else return a;
		}

	public static void main(String[] args) {
		System.out.println(sumLimit(2, 3));
		System.out.println(sumLimit(8, 3));
		System.out.println(sumLimit(8, 1));

	}

}
