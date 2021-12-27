package Com.epam.HomeTask.OOPS.NewYearGift;

import java.util.HashMap;
import java.util.Map;

public class Chocolates extends Gift {
	static int count = 0, total = 0;

	public void getChocolates() {
		Map<String, Integer> choco = new HashMap<>();
		choco.put("FerreroRocher", 10);
		choco.put("Cadbury", 5);
		choco.put("Nestle", 8);
		choco.put("Hershey", 12);
		choco.put("Campco", 18);
		choco.put("Pacari", 20);
		for (Map.Entry<String, Integer> mapElement : choco.entrySet()) {
			total += mapElement.getValue();
			count++;
			System.out.println(
					"Chocolate Name " + mapElement.getKey() + "				->  = " + mapElement.getValue());
		}
		Gift poly = new Chocolates();
		System.out.println("Total weigth of the chocolates                      = " + poly.sumOfTheQuantity(total));
		System.out.println("Total number of chocolates                          = " + poly.countOfTheQuantity(count));
	}

}
