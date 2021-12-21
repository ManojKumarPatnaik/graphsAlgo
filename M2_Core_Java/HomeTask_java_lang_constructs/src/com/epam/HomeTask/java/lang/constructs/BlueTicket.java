package com.epam.HomeTask.java.lang.constructs;

public class BlueTicket {
	public static int blueTicket(int a, int b, int c) {
		int ab = a + b;
		int bc = b + c;
		int ac = a + c;
		if (ab == 10 || bc == 10 || ac == 10) return 10;
		if (ab - bc == 10 || ab - ac == 10) return 5;
		else return 0;
	}
	public static void main(String[] args) {
		int x=blueTicket(9, 1, 0);
		x=blueTicket(9, 2, 0);
		x=blueTicket(6, 1, 4);
		if (x == 10)
			System.out.println("Result = 10");
		if (x == 0)
			System.out.println("Result = 0");
		if (x == 5)
			System.out.println("Result = 5");
	}

}
