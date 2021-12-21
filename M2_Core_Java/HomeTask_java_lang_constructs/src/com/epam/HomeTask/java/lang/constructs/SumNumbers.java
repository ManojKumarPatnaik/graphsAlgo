package com.epam.HomeTask.java.lang.constructs;

public class SumNumbers {
	public static int sumNumbers(String str) {
		int sum = 0;
		String str2 = str.replaceAll("[^0-9]+"," ");
		String arr[] = str2.trim().split(" ");
		for(int i = 0;i<arr.length;i++){
		if(arr[i]!=null && !arr[i].isEmpty()){
		sum += Integer.parseInt(arr[i]);
		}
		}
		return sum;
		}

	public static void main(String[] args) {
		System.out.println(sumNumbers("cjdsjcs11jknvjd22"));

	}

}
