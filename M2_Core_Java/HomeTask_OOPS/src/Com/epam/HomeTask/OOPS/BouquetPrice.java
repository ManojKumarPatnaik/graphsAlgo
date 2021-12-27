package Com.epam.HomeTask.OOPS;

import java.util.ArrayList;
import java.util.List;

public class BouquetPrice {
    List<Flower> tmpList=new ArrayList<Flower>();
    private double price=0;
    public BouquetPrice addFlower(Flower flwr) {
        tmpList.add(flwr);
        return this;
    }
    public double getPrice() {
        for (Flower flwr:tmpList) {
            price=price+flwr.getPrice();
        }
        return price;

    }
}