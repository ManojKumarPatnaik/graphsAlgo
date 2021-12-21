package com.epam.HomeTask.java.lang.constructs;

public class ShareDigit {
	public static boolean shareDigit(int a, int b) {
		  return (a/10==b/10 || b/10==a%10 ||a/10==b%10|| b%10==a%10 );
		}
	

	public static void main(String[] args) {
		System.out.println(shareDigit(12, 23));
		System.out.println(shareDigit(12, 43));
		System.out.println(shareDigit(12, 44));
	}

}
