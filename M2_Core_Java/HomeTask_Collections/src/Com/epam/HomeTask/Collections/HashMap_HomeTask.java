package Com.epam.HomeTask.Collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap_HomeTask {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Manoj", 1007);
		map.put("Kumar", 1011);
		map.put("Durga", 1052);
		map.put("Shiva", 2007);
		map.put("Ram", 1000);
//		Traversing Using for Each loop
//		for(Map.Entry<String,Integer> itr:map.entrySet()) {
//			System.out.println(itr.getKey()+" = "+itr.getValue());
//		}

		Set set = map.entrySet();
		System.out.println("Sorting Map Using Streams concept in Ascending Order");
		set.stream().sorted(Map.Entry.comparingByKey(Comparator.naturalOrder())).forEach(System.out::print);
		System.out.println("\nSorting Map Using Streams concept in Descending Order");
		set.stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::print);
		System.out.println();
		// Traversing Using Iterator interface
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.println(entry.getKey() + "	" + entry.getValue());
		}

	}

}
