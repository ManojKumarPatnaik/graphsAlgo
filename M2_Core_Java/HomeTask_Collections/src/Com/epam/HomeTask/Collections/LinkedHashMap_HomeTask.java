package Com.epam.HomeTask.Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap_HomeTask {

	public static void main(String[] args) {
		Map<Integer, String> linkedhashmap = new LinkedHashMap<>();
		linkedhashmap.put(101, "Manoj");
		linkedhashmap.put(102, "Kumar");
		linkedhashmap.put(107, "shiva");
		linkedhashmap.put(109, "Ram");
		linkedhashmap.put(123, "Durga");
		System.out.println("All keys\n" + linkedhashmap.keySet());
		System.out.println("All Values\n" + linkedhashmap.values());
		System.out.println("Both Keys and Values\n" + linkedhashmap.entrySet());
		for (Map.Entry<Integer, String> hash : linkedhashmap.entrySet()) {
			System.out.println(hash.getKey() + "	" + hash.getValue());
		}
		linkedhashmap.remove(109);
		System.out.println(linkedhashmap);

	}

}
