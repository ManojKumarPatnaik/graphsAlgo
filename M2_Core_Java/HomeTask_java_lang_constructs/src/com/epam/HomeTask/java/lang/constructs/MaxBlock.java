package com.epam.HomeTask.java.lang.constructs;

public class MaxBlock {
	public static int maxBlock(String str) {
		int n=0, res=0;
		char previousc=0;
		for(char c : str.toCharArray()) {
		n = c == previousc ? n+1 : 1;
		if (n > res)
		res = n;
		previousc = c;
		}
		return res;
		}

	public static void main(String[] args) {
		System.out.println(maxBlock("hello"));
		System.out.println(maxBlock("abbcccdddd"));
		System.out.println(maxBlock("manojkumar"));
	}

}
