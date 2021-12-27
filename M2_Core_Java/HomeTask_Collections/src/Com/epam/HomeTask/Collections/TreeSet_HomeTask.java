package Com.epam.HomeTask.Collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet_HomeTask {

	public static void main(String[] args) {
		TreeSet<String> Treeset = new TreeSet<>();
		Treeset.add("Manoj");
		Treeset.add("shiva");
		Treeset.add("ram");
		Treeset.add("durga");
		Iterator<String> itr = Treeset.iterator();
		while (itr.hasNext()) {
			System.out.println("Ascending order=\t" + itr.next());
		}
		System.out.println();
		System.out.println("First Poll	" + Treeset.pollFirst());
		System.out.println("Last Poll	" + Treeset.pollLast());
		System.out.println("Reverse Set: " + Treeset.descendingSet());

		System.out.println("Head Set: " + Treeset.headSet("ram", true));

		System.out.println("SubSet: " + Treeset.subSet("Manoj", false, "ram", true));

		System.out.println("TailSet: " + Treeset.tailSet("durga", false));
		System.out.println();
		Iterator<String> itr2 = (Treeset).descendingIterator();
		while (itr2.hasNext()) {
			System.out.println("Descending Order=\t" + itr2.next());
		}
	}

}
