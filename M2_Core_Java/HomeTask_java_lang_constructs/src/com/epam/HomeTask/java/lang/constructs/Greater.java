package com.epam.HomeTask.java.lang.constructs;

public class Greater {
	public static boolean inOrder(int a, int b, int c, boolean bOk) {
		  if (bOk){
		return (b<c);
		}
		return (a<b && b<c);
		}

	public static void main(String[] args) {
		boolean x=inOrder(1, 2, 4, false);
		x=inOrder(1, 2, 1, false);
		x=inOrder(1, 1, 2, true);
		if(x==true) {
			System.out.println("b is greater than a, and c is greater than b");
		}
		else
		System.out.println(" b does not need to be greater than a");

	}

}
