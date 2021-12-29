package com.epam.HomeTask.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorReverseOrder {

	public static void main(String[] args) {
		List<Integer>list=new ArrayList<>();
		list.add(10);
		list.add(120);
		list.add(30);
		list.add(70);
		list.add(190);
		
		Collections.sort(list,(s1,s2)->s2.compareTo(s1));
		System.out.println("With Lambda Expression = "+list);
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("Without Lambda Expression = "+list);
		

	}

}
