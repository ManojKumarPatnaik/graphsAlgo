package Com.epam.HomeTask.OOPS.NewYearGift;

import java.util.Scanner;

public class NewYear {
	public static void main(String[] args) {
		Chocolates chocolate = new Chocolates();
		Sweets sweets=new Sweets();
				
		Scanner scan=new Scanner(System.in);	
		
		System.out.println("Enter the name of the customer : ");
		String CustomerName=scan.nextLine();
		System.out.println("Choose any one chocolate or sweet : ");
		String gift=scan.next();
		System.out.println(CustomerName+" wants "+gift);
		gift=gift.toLowerCase();
		scan.close();
		if(gift.equalsIgnoreCase("chocolate")) {
			chocolate.getChocolates();
			System.out.println();
		}else if(gift.equalsIgnoreCase("sweet")){
			sweets.getSweets();
			System.out.println();
		}
		else {
			System.out.println("Incorrect gift name");
		}
	}
}
