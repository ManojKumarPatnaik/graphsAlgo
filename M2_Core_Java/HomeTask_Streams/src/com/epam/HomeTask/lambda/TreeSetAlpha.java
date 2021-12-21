package com.epam.HomeTask.lambda;

import java.util.TreeSet;

public class TreeSetAlpha {

	public static void main(String[] args) {
		TreeSet<Object> set = new TreeSet<Object>();
		set.add("Manoj");
		set.add("Kumar");
		set.add("Uriti");
		set.add("Patnaik");
		set.add("Anonymous");
		set.add("Geetha");
		System.out.println("Alphabetic order = " + set);
		TreeSet<Object> setReverse = (TreeSet<Object>) set.descendingSet();
		System.out.println("With descendingSet = " + setReverse);

	}

}
