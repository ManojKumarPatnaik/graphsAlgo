package Com.epam.HomeTask.Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSet_HomeTask {

	public static void main(String[] args) {
		Set<String> hashset = new HashSet<>();
		hashset.add("Manoj");
		hashset.add("shiva");
		hashset.add("ram");
		hashset.add("durga");
		hashset.add("removeElement");
		System.out.println("Initial HashSet :\n" + hashset + "\n");
		Set<String> hashset1 = new HashSet<>();
		hashset1.addAll(hashset);
		List<String> list = new ArrayList<>(hashset1);
		list.add("list is add");
		list.remove("removeElement");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		list.clear();
		System.out.println("Clear the data = " + list);
	}

}
