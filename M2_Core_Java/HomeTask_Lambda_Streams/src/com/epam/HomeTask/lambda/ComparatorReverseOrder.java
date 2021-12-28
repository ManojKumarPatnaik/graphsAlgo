package com.epam.HomeTask.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorReverseOrder {

	public static void main(String[] args) {
		List<Integer>list=new ArrayList<>();
		list.add(10);
		list.add(120);
		list.add(30);
		list.add(70);
		list.add(190);
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		

	}

}
