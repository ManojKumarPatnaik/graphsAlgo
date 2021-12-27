package Com.epam.HomeTask.Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMap_HomeTask {

	public static void main(String[] args) {
		TreeMap<Integer, String> treemap = new TreeMap<>();
		treemap.put(101, "Manoj");
		treemap.put(102, "Kumar");
		treemap.put(107, "shiva");
		treemap.put(109, "Ram");
		treemap.put(123, "Durga");
		System.out.println("All keys\n" + treemap.keySet());
		System.out.println("All Values\n" + treemap.values());
		System.out.println("Both Keys and Values\n" + treemap.entrySet());
		for (Map.Entry<Integer, String> hash : treemap.entrySet()) {
			System.out.println(hash.getKey() + "	" + hash.getValue());
		}
		treemap.remove(109);
		System.out.println(treemap);
		System.out.println("descendingMap: " + treemap.descendingMap());
		// Returns key-value pairs whose keys are less than or equal to the specified
		// key.
		System.out.println("headMap: " + treemap.headMap(102, true));
		// Returns key-value pairs whose keys are greater than or equal to the specified
		// key.
		System.out.println("tailMap: " + treemap.tailMap(102, true));
		// Returns key-value pairs exists in between the specified key.
		System.out.println("subMap: " + treemap.subMap(101, false, 123, true));
	}

}
