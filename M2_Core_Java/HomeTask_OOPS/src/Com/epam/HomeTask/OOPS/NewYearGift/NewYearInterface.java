package Com.epam.HomeTask.OOPS.NewYearGift;


public interface NewYearInterface {
public void display();
}

 class NewYearImplementation implements NewYearInterface {
	private String customerName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Override
	public void display() {
		
		System.out.println("Enter the name of the customer : ");
		
	}
	
	
}
