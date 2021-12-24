package Com.epam.HomeTask.OOPS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class Flowers  {
public void displayAllFlowers() {
	List<String> list=new ArrayList<>();
	list.add("Rose Flower");
	list.add("Lily Flower");
	list.add("Daffodil Flower");
	list.add("Orchid Flower");
	Collections.sort(list);
	System.out.println("Sorted list of flowers = "+list);
}
public void display() {
//	System.out.println("List of Flowers");
}
}
