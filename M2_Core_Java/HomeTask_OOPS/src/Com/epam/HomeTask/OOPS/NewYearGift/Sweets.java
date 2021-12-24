package Com.epam.HomeTask.OOPS.NewYearGift;

import java.util.HashMap;
import java.util.Map;

public class Sweets extends NewYear {
	static int sum = 0,count=0;
 	public void getSweets() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Aamras", 10);
		map.put("Carrot Halwa", 20);
		map.put("Kaju Katli", 15);
		map.put("Gulab Jamun", 8);
		map.put("Ladoo", 12);
		map.put("Kulfi", 5);

		for (Map.Entry<String, Integer> mapELement : map.entrySet()) {
			String key = (String) mapELement.getKey();
			Integer value = (Integer) mapELement.getValue();
			sum += mapELement.getValue();
			count++;
			System.out.println("Sweet Name"+ key + "-> Weight = " + value );
		}
		System.out.println("Total weigth of the sweets = " + sum);
		System.out.println("Total number of the sweets = " + count);
	}

}
