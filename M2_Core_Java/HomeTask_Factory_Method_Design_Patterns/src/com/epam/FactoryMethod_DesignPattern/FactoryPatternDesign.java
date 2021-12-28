package com.epam.FactoryMethod_DesignPattern;

public class FactoryPatternDesign {
	public static void main(String[] args) {
		   
	   	  double buoquetCost;
	      BuoquetFactory buoquetFactory = new BuoquetFactory();
	   
	      Flowers rose = buoquetFactory.getFlowers("Rose");
	      Flowers jasmine = buoquetFactory.getFlowers("Jasmine");
	      Flowers lily = buoquetFactory.getFlowers("Lily");

	      buoquetCost=rose.getPrice(2)+jasmine.getPrice(2)+lily.getPrice(2);
	      
	      System.out.print("Price of flower buoquet: "+buoquetCost);
 }
}
