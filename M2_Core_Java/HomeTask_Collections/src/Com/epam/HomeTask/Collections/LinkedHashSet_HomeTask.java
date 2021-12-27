package Com.epam.HomeTask.Collections;

import java.util.LinkedHashSet;
import java.util.Set;

class Apps {
	String appName;
	int appSize;
	String author;

	public Apps(String appName, int appSize, String author) {
		this.appName = appName;
		this.appSize = appSize;
		this.author = author;
	}

}

public class LinkedHashSet_HomeTask {

	public static void main(String[] args) {
		Set<Apps> set = new LinkedHashSet<>();
		Apps a = new Apps("Chrome", 200, "Google");
		Apps a1 = new Apps("Brave", 150, "Brave");
		Apps a3 = new Apps("BGMI", 1024, "PUBG");
		set.add(a1);
		set.add(a);
		set.add(a3);
		for (Apps i : set) {
			System.out.println(i.appName + "	" + i.appSize + "	" + i.author);
		}
	}

}
