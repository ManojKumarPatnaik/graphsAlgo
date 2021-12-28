package com.epam.HomeTask.lambda;

import java.util.ArrayList;
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
		list.sort(Comparator.naturalOrder());
		System.out.println(list);
	}

}
