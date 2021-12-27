package Com.epam.HomeTask.OOPS.NewYearGift;


public interface NewYearInterface {
public void display();
}

 class NewYearImplementation implements NewYearInterface {
	private String customer;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public void display() {
		
		System.out.println("Enter the name of the customer : ");
		
	}
	
	
}
