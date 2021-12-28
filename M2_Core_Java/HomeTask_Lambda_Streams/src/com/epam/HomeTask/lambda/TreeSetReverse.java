package com.epam.HomeTask.lambda;

import java.util.TreeSet;

public class TreeSetReverse {

	public static void main(String[] args) {
		TreeSet<Object> set = new TreeSet<Object>();
		set.add(132);
		set.add(420);
		set.add(810);
		set.add(95);
		set.add(37);
		set.add(63);
		TreeSet<Object> setReverse = (TreeSet<Object>) set.descendingSet();
		System.out.println("Without descendingSet = " + set);
		System.out.println("With descendingSet = " + setReverse);
	}

}
