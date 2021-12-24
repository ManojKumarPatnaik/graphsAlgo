package Com.epam.HomeTask.OOPS.NewYearGift;


import java.util.HashMap;

import java.util.Map;

public class Chocolates {
	static int count=0,total=0;
	public void getChocolates() {
		Map<String,Integer> choco=new HashMap<>();
		choco.put("Ferrero Rocher",10);
		choco.put("Cadbury", 5);
		choco.put("Nestle", 8);
		choco.put("Hershey", 12);
		choco.put("Campco", 18);
		choco.put("Pacari",20);
		for(Map.Entry<String, Integer> mapElement:choco.entrySet()) {
			total+=mapElement.getValue();
			count++;
			System.out.println("Chocolate Name"+mapElement.getKey() + "->  = " +mapElement.getValue() );
		}
		System.out.println("Total weigth of the chocolates = " + total);
		System.out.println("Total number of chocolates = "+count);
	}
//	public String getChocolates1() {
//		Chocolates obj=new Chocolates();
//				
//		return obj.getChocolates();;
//		
//	}
	

}
