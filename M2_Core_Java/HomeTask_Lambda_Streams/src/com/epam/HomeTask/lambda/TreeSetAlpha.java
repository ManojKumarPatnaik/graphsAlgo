package com.epam.HomeTask.lambda;

import java.util.TreeSet;

public class TreeSetAlpha {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>((S1,S2)->S2.compareTo(S1));
		set.add("Manoj");
		set.add("Kumar");
		set.add("Uriti");
		set.add("Patnaik");
		set.add("Anonymous");
		set.add("Geetha");
		System.out.println("Descending Order = " + set);
		TreeSet<String> setReverse = (TreeSet<String>) set.descendingSet();
		System.out.println("Alphabetic order = " + setReverse);

	}

}
