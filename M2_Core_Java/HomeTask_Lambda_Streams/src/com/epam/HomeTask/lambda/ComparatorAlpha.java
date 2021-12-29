package com.epam.HomeTask.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAlpha {

	public static void main(String[] args) {
		List<String>list=new ArrayList<>();
		list.add("Manoj");
		list.add("Kumar");
		list.add("Uriti");
		list.add("Patnaik");
		list.add("Anonymous");
		Collections.sort(list,(s1,s2)->s1.compareTo(s2));
		System.out.println("With Lambda Expression = "+list);
		Collections.sort(list,Comparator.naturalOrder());
		System.out.println("Without Lambda Expression = "+list);
	}

}
