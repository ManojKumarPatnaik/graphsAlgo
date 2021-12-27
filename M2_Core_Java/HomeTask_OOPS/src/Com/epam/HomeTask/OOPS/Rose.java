package Com.epam.HomeTask.OOPS;

public class Rose extends Flower{
    private static final double rosePrice=1.0;
    private static double price;
    public Rose (int quantity) {
        this.quantity=quantity;
        if (this.quantity < 0) {
            // this gets caught in the catch block
            throw new IllegalArgumentException("Only positive numbers");
        }
        price=this.quantity*rosePrice;
    }
    public double getPrice() {
        return price;
    }

}