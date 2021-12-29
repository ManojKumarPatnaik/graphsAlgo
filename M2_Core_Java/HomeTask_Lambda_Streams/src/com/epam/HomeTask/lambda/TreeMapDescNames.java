package com.epam.HomeTask.lambda;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class TreeMapDescNames {

	public static void main(String[] args) {
		Map<String, Integer> treemap = new TreeMap<>();
		treemap.put("Manoj", 182);
		treemap.put("Shiva", 374);
		treemap.put("Ravi", 937);
		treemap.put("Ajeet", 245);

		LinkedList<String> list = new LinkedList<>();
		for (Map.Entry<String, Integer> itr : treemap.entrySet()) {
			list.add(itr.getKey());
		}
//		Collections.sort(list,Comparator.reverseOrder());
//		System.out.println("Without Lambda"+list);
		Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
		for (String st : list) {
			for (Map.Entry<String, Integer> entry : treemap.entrySet()) {
				if (entry.getKey().equals(st)) {
					System.out.println(entry.getKey() + "	= " + entry.getValue());

				}
			}
		}

	}

}
