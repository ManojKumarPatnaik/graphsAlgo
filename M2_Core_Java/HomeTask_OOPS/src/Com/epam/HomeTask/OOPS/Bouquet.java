package Com.epam.HomeTask.OOPS;

public class Bouquet {

	public static void main(String[] args) {
		Flowers flower=new Rose();
		flower.display();
		flower =new Lily();
		flower.display();
		flower=new Orchid();
		flower.display();
		flower=new Daffodil();
		flower.display();
		BouquetImplementation object=new BouquetImplementation("Gebera");
		object.display();
		Flowers flowers=new Flowers();
		flowers.displayAllFlowers();
		
	}

}
