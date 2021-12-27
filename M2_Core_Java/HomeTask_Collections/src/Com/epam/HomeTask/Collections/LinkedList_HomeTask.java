package Com.epam.HomeTask.Collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_HomeTask {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add(new String("Manoj"));
		list.add("Kumar");
		list.add("Uriti");
		list.add(3, "Durga");
		int size = list.size();
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			for (int i = size - 1; i >= 0; i--) {
				System.out.println("Resverse order = " + list.get(i) + " Actual Order = " + iterator.next());
			}
			System.out.println(list.toString());

		}
		list.addAll(list);
		Collections.sort(list);
		System.out.println(list);

	}

}
