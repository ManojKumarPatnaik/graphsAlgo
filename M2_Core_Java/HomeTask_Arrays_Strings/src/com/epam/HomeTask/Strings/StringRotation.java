package com.epam.HomeTask.Strings;

import java.util.Scanner;

public class StringRotation {
	static boolean areRotational(String str1,String str2) {
		return (str1.length()==str2.length()&&((str1+str1).indexOf(str2)!=-1));
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		String str1=scan.next();
		scan.close();
		if(areRotational(str,str1)) {
			System.out.println("Strings are rotations of each other");
		}else System.out.println("Strings are not rotations of each other");

	}

}
