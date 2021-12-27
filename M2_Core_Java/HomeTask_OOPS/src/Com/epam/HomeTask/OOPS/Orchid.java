package Com.epam.HomeTask.OOPS;

public class Orchid extends Flower{
    private static final double orchidPrice=1.0;
    private static double price;
    public Orchid (int quantity) {
        this.quantity=quantity;
        if (this.quantity < 0) {
            // this gets caught in the catch block
            throw new IllegalArgumentException("Only positive numbers");
        }
        price=this.quantity*orchidPrice;
    }
    public double getPrice() {
        return price;
    }

}