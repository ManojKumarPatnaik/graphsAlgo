package com.epam.HomeTask.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDescValues {

	public static void main(String[] args) {
		TreeMap<String, Integer> treemap = new TreeMap<>();
		treemap.put("Manoj", 1);
		treemap.put("kumar", 2);
		treemap.put("Ravi", 3);
		treemap.put("ajeet", 4);

		LinkedList<Integer> list = new LinkedList<>();
		for (Map.Entry<String, Integer> itr : treemap.entrySet()) {
			list.add(itr.getValue());
		}
		Collections.sort(list, Comparator.reverseOrder());
		for (Integer itr : list) {
			for (Map.Entry<String, Integer> entry : treemap.entrySet()) {
				if (entry.getValue().equals(itr)) {
					System.out.println(entry.getKey() + "	= " + entry.getValue());

				}

			}
		}
	}
}
