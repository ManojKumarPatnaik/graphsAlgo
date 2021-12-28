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
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
	}

}
