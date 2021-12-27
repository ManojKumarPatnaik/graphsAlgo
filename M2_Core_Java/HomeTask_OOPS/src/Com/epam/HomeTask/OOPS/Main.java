package Com.epam.HomeTask.OOPS;

public class Main {
    public static void main(String[] args) {
       

        BouquetPrice priceOfBuoquet=new BouquetPrice().addFlower(new Rose(3)).
                addFlower(new Lily(4)).addFlower(new Daffodil(2)).addFlower(new Orchid(5));
        System.out.println("Price of Buoquet: "+priceOfBuoquet.getPrice());

    }
}


