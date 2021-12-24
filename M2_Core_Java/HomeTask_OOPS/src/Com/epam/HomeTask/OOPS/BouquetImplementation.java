package Com.epam.HomeTask.OOPS;

public class BouquetImplementation implements BouquetInterface{

	private String name;
	public BouquetImplementation(String name) {

		this.name = name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	@Override
	public void display() {
		BouquetImplementation obj=new BouquetImplementation("Gerbera");

		System.out.println("This is "+obj.getName()+" flower");
	}
	
}