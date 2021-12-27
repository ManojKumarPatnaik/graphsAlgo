package Com.epam.HomeTask.OOPS;

public class Lily extends Flower{
    private static final double lilyPrice=2.0;
    private static double price;
    public Lily(int quantity) {
        this.quantity=quantity;
        if (this.quantity < 0) {
            // this gets caught in the catch block
            throw new IllegalArgumentException("Only positive numbers");
        }
        price=this.quantity*lilyPrice;
    }
    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return price;
    }
}
