package com.epam.HomeTask.lambda;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class CollectionsSort {

	public static void main(String[] args) {
		List<String> list=new LinkedList<>();
		list.add("Manoj");
		list.add("Kumar");
		list.add("Uriti");
		list.add("Patnaik");
		list.add("Anonymous");
		Collections.sort(list,(s1,s2)->s2.compareTo(s1));
		System.out.println("With Lambda Expression = "+list);
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("Without Lambda Expression = "+list);
	}

}
