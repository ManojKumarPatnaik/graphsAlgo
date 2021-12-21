package com.epam.HomeTask.java.lang.constructs;

public class TeaParty {
	public static int teaParty(int tea, int candy) {
		if (tea < 5 || candy < 5)
			return 0;
		if (candy * 2 <= tea || tea * 2 <= candy)
			return 2;
		return 1;
	}

	public static void main(String[] args) {
		int x = teaParty(6, 8);
		x = teaParty(3, 8);
		x = teaParty(20, 6);
		
		if (x == 0)
			System.out.println("Bad");
		if (x == 1)
			System.out.println("Good");
		if (x == 2)
			System.out.println("Great");
	}

}
