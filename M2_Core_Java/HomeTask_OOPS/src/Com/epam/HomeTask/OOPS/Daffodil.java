package Com.epam.HomeTask.OOPS;

public class Daffodil extends Flower {
    private static final double daffodilPrice = 2.0;
    private static double price;

    public Daffodil(int quantity) {
        this.quantity = quantity;
        if (this.quantity < 0) {
            // this gets caught in the catch block
            throw new IllegalArgumentException("Only positive numbers");
        }
        price = this.quantity * daffodilPrice;
    }

    public double getPrice() {
        // TODO Auto-generated method stub
        return price;
    }
}